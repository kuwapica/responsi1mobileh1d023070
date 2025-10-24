package com.example.responsi1mobileh1d023070.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.responsi1mobileh1d023070.data.model.TeamResponse
import com.example.responsi1mobileh1d023070.data.repository.FootballRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = FootballRepository()
    private val _teamData = MutableLiveData<TeamResponse>()
    val teamData: LiveData<TeamResponse> = _teamData
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun loadJuventusData() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null

                val data = repository.getJuventusData()
                _teamData.value = data

                _isLoading.value = false
            } catch (e: Exception) {
                _error.value = e.message ?: "Unknown error occurred"
                _isLoading.value = false
            }
        }
    }
}