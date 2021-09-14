package com.example.zykov.bankapp.screens.convert

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zykov.bankapp.databinding.FragmentConvertBinding
import com.example.zykov.bankapp.models.AppObject
import android.widget.ArrayAdapter
import com.example.zykov.bankapp.R
import java.lang.String.format


class ConvertFragment : Fragment() {
    private var _binding: FragmentConvertBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: ConvertFragmentViewModel
    // private lateinit var mCurrent: AppObject

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
                val n: Double
                if (str == null || str.isEmpty()) {
                } else {
                    n = str.toString().toDouble()
                    mBinding.resultText.text = format(
                        "%.2f",
                        n / mViewModel.getValue(mBinding.autoCompleteTextView.text.toString())
                    ).toString()
                }
            }
        })

        mBinding.autoCompleteTextView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(str: CharSequence?, start: Int, before: Int, count: Int) {
                val n: Double = mBinding.editTextNumber.text.toString().toDouble()
                if (str == null || str.isEmpty()) {
                } else {
                    mBinding.resultText.text = format(
                        "%.2f",
                        n / mViewModel.getValue(str.toString())
                    ).toString()
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        val arrayAdapter = ArrayAdapter(
            requireContext(),
            R.layout.dropdown_item,
            mViewModel.mCurrent.Valute.list!!.map { it.Name })
        mBinding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}