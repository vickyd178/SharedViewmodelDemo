package com.avion.sharedviewmodeldemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private var _country = MutableLiveData("India")
    val country: LiveData<String> get() = _country

    fun setCountry(newCountry: String) {
        _country.value = newCountry
    }
}