package com.wapekk.imdb.viewModel

import com.wapekk.imdb.model.LoginRequest
import com.wapekk.imdb.model.RegisterRequest
import com.wapekk.imdb.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class ViewModelAuth(private val repository: AuthRepository) : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val  isLoading = _isLoading.asStateFlow()

    private val _message = MutableStateFlow("")
    val message = _message.asStateFlow()

    private val _isSuccess = MutableStateFlow(false)
    val isSuccess = _isSuccess.asStateFlow()

    fun register(fullName: String, phone: String, email: String, password: String, confirmPassword: String) {
        if (password != confirmPassword) {
            _message.value = "Password Tidak Cocok"
            return
        }

        viewModelScope.launch {
            _isLoading.value = true
            val request = RegisterRequest(fullName, phone, email, password)
            val response = repository.register(request)

            _message.value = response.message
            _isSuccess.value = response.success
            _isLoading.value = false
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val request = LoginRequest(email, password)
            val response = repository.login(request)

            _message.value = response.message
            _isSuccess.value = response.success
            _isLoading.value = false
        }
    }

    fun resetState() {
        _isSuccess.value = false
        _message.value = ""
    }
}