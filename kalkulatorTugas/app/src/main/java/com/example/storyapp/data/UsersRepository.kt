package com.example.storyapp.data

import com.example.storyapp.data.prefer.UserModel
import com.example.storyapp.data.prefer.UserPreference
import kotlinx.coroutines.flow.Flow

class UsersRepository private constructor(private val userPreference: UserPreference){
    suspend fun saveSession(userModel: UserModel){
        userPreference.saveSession(userModel)
    }
    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }
    suspend fun logout(){
        userPreference.logout()
    }
    companion object{
        @Volatile
        private var instance:UsersRepository?=null
        fun getInstance(userPreference: UserPreference):UsersRepository=
            instance?: synchronized(this){
                instance?:UsersRepository(userPreference)
            }.also { instance=it }
    }
}