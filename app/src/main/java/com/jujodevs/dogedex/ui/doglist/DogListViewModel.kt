package com.jujodevs.dogedex.ui.doglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jujodevs.dogedex.data.DogRepository
import com.jujodevs.dogedex.domain.model.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogListViewModel @Inject constructor(
    private val dogRepository: DogRepository
) : ViewModel() {

    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList: LiveData<List<Dog>> get() = _dogList

    init {
        dowloadDogs()
    }

    private fun dowloadDogs() {
        viewModelScope.launch{
            _dogList.value = dogRepository.downloadDogs()
        }
    }
}