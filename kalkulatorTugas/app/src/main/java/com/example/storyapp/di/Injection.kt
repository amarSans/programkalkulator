package com.example.storyapp.di

import android.content.Context
import com.example.storyapp.data.UsersRepository
import com.example.storyapp.data.prefer.UserPreference
import com.example.storyapp.data.prefer.dataStore

object Injection {
    fun provideRepository(context: Context):UsersRepository{
        val prefer=UserPreference.getInstance(context.dataStore)
        return UsersRepository.getInstance(prefer)
    }
}