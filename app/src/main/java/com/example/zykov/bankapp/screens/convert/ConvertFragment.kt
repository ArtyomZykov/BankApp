package com.example.zykov.bankapp.screens.convert

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zykov.bankapp.R
import com.example.zykov.bankapp.databinding.FragmentConvertBinding
import com.example.zykov.bankapp.models.AppObject

class ConvertFragment : Fragment() {
    private var _binding: FragmentConvertBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: ConvertFragmentViewModel
    private lateinit var mCurrentNote: AppObject

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConvertBinding.inflate(layoutInflater, container, false)
        //mCurrentNote = arguments?.getSerializable("list") as AppObject
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        //mBinding.noteText.text = mCurrentNote.text
        //mBinding.noteName.text = mCurrentNote.name
        mViewModel = ViewModelProvider(this).get(ConvertFragmentViewModel::class.java)
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.note_actiom_menu, menu)
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId) {
//            R.id.btn_delete -> {
//                mViewModel.delete(mCurrentNote) {
//                    APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_mainFragment)
//                }
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}