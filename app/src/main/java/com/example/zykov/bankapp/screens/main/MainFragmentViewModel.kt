package com.example.zykov.bankapp.screens.main

import android.app.Application
import android.content.ClipData
import android.util.Log
import androidx.lifecycle.*
import com.example.zykov.bankapp.models.AppObject
import com.example.zykov.bankapp.models.Items
import com.example.zykov.bankapp.parser.Repository
import com.example.zykov.bankapp.utilites.APP_ACTIVITY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(private val repository: Repository) : ViewModel() {

    val mResponse: MutableLiveData<AppObject> by lazy {
        MutableLiveData<AppObject>()
    }

    fun getCourse() {
        viewModelScope.launch(Dispatchers.IO) {
            val response: AppObject = repository.getCourse()
            response.Valute.setList()
            viewModelScope.launch(Dispatchers.Main) {
                mResponse.value = response
            }
        }
    }
}