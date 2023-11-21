package com.example.storyapp.view.login

import androidx.lifecycle.*
import com.example.storyapp.data.UsersRepository
import com.example.storyapp.data.prefer.UserModel
import kotlinx.coroutines.launch

class LoginModeView(private val repository: UsersRepository) : ViewModel() {
    fun saveSession(userModel: UserModel) {
        viewModelScope.launch {
            repository.saveSession(userModel)
        }
    }
}