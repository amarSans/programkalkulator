package com.example.storyapp.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.storyapp.data.UsersRepository
import com.example.storyapp.data.prefer.UserModel
import kotlinx.coroutines.launch

class MainModelView(private val repository: UsersRepository): ViewModel() {
    fun getSession():LiveData<UserModel>{
        return repository.getSession().asLiveData()
    }
    fun logout(){
        viewModelScope.launch { repository.logout() }
    }
}