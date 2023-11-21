package com.example.storyapp.view

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.storyapp.data.UsersRepository
import com.example.storyapp.di.Injection
import com.example.storyapp.view.login.LoginModeView
import com.example.storyapp.view.main.MainActivity
import com.example.storyapp.view.main.MainModelView

class ViewModelFactory(private val repository: UsersRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MainModelView::class.java)->{
                MainModelView(repository) as T
            }
            modelClass.isAssignableFrom(LoginModeView::class.java)->{
                LoginModeView(repository) as T
            }

            else-> throw IllegalArgumentException("unknow view model class:${modelClass.name}")
        }
    }
    companion object{
        @Volatile
        private var INSTANCE:ViewModelFactory?=null
        @JvmStatic
        fun getInstance(context: Context):ViewModelFactory{
            synchronized(ViewModelFactory::class.java){
                INSTANCE= ViewModelFactory(Injection.provideRepository(context))
            }
            return INSTANCE as ViewModelFactory
        }
    }
}