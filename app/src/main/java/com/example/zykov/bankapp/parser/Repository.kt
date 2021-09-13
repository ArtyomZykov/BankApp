package com.example.zykov.bankapp.parser

import android.util.Log
import com.example.zykov.bankapp.models.AppObject
import com.example.zykov.bankapp.parser.retrofit.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getCourse(): AppObject {
        return RetrofitInstance.api.getCourse()
    }
}