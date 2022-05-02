package com.avion.sharedviewmodeldemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.avion.sharedviewmodeldemo.databinding.FragmentProfileBinding
import com.avion.sharedviewmodeldemo.viewmodels.SharedViewModel

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSave.setOnClickListener {
            sharedViewModel.setCountry(binding.editText.text.toString())
            Navigation.findNavController(binding.root).navigate(R.id.navProfileToHome)
        }

        sharedViewModel.country.observe(viewLifecycleOwner){country->
            binding.editText.setText(country)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}