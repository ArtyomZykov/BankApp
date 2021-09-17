package com.example.zykov.bankapp.screens.convert

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.zykov.bankapp.models.AppObject

class ConvertFragmentViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var mCurrent: AppObject

    fun getValue(name: String): Double {
        mCurrent.valute.list?.forEach {
            it.value
            if (it.name == name) {
                return it.value
            }
        }
        return 0.0
    }
}