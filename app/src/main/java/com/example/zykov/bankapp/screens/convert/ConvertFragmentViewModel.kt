package com.example.zykov.bankapp.screens.convert

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.zykov.bankapp.models.AppObject

class ConvertFragmentViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var mCurrent: AppObject

    fun getValue(name: String): Double {
        mCurrent.Valute.list?.forEach {
            it.Value
            if (it.Name == name) {
                return it.Value
            }
        }
        return 0.0
    }
}