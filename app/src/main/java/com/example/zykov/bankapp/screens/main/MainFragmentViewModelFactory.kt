package com.example.zykov.bankapp.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zykov.bankapp.parser.Repository

class MainFragmentViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainFragmentViewModel(repository) as T
    }
}