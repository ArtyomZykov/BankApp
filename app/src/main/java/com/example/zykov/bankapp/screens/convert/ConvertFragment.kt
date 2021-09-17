package com.example.zykov.bankapp.screens.convert

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zykov.bankapp.databinding.FragmentConvertBinding
import com.example.zykov.bankapp.models.AppObject
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.zykov.bankapp.R
import com.example.zykov.bankapp.utilites.APP_ACTIVITY
import java.lang.String.format


class ConvertFragment : Fragment() {
    private var _binding: FragmentConvertBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: ConvertFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConvertBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        mViewModel = ViewModelProvider(this).get(ConvertFragmentViewModel::class.java)
        mViewModel.mCurrent = arguments?.getSerializable("object") as AppObject
        mBinding.editTextNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(str: CharSequence?, start: Int, before: Int, count: Int) {
                if (str == null || str.isEmpty()) {
                    mBinding.resultText.text = ""
                } else {
                    val n: Double = str.toString().toDouble()
                    if (mViewModel.getValue(mBinding.autoCompleteTextView.text.toString()) != 0.0) {
                        mBinding.resultText.text = format(
                            "%.2f",
                            n / mViewModel.getValue(mBinding.autoCompleteTextView.text.toString())
                        ).toString()
                    } else {
                        Toast.makeText(APP_ACTIVITY, "Выберите валюту", LENGTH_SHORT).show()
                    }
                }
            }
        })
        mBinding.autoCompleteTextView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(str: CharSequence?, start: Int, before: Int, count: Int) {
                val s: String? = mBinding.editTextNumber.text.toString()
                if (str == null || str.isEmpty()) {
                } else {
                    if (s!!.isNotEmpty() && s != null) {
                        mBinding.resultText.text = format(
                            "%.2f",
                            s.toDouble()?.div(mViewModel.getValue(str.toString()))
                        ).toString()
                    } else {
                        mBinding.resultText.text = ""
                        Toast.makeText(APP_ACTIVITY, "Выведите количество валюты", LENGTH_SHORT)
                            .show()
                    }
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        val arrayAdapter = ArrayAdapter(
            requireContext(),
            R.layout.dropdown_item,
            mViewModel.mCurrent.valute.list!!.map { it.name })
        mBinding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}