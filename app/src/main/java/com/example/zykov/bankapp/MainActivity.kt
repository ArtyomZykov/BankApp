package com.example.zykov.bankapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.zykov.bankapp.databinding.ActivityMainBinding
import com.example.zykov.bankapp.utilites.APP_ACTIVITY


class MainActivity : AppCompatActivity() {
    lateinit var mToolBar: Toolbar
    lateinit var navController: NavController
    private var _binding: ActivityMainBinding? = null
    val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        mToolBar = mBinding.toolbar
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(mToolBar)
        title = getString(R.string.title)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}