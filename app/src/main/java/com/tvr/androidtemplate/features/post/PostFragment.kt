package com.tvr.androidtemplate.features.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.base.ViewState
import com.tvr.androidtemplate.databinding.ActivityHomeBinding
import com.tvr.androidtemplate.databinding.FragmentPostBinding
import com.tvr.androidtemplate.features.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostFragment : Fragment() {
    private lateinit var binding: FragmentPostBinding
    private val viewModel: PostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = FragmentPostBinding.inflate(layoutInflater)
        view.viewmodel = viewModel
        view.lifecycleOwner = viewLifecycleOwner
        viewModel.getPost()
        observeData();
        return view.root;
    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel.data.collect{
                when(it){
                    is ViewState.Loading -> {
                        Toast.makeText(activity, "Loading", Toast.LENGTH_LONG)
                            .show()
                    }
                    is ViewState.Success -> {
                        Toast.makeText(activity, "Success", Toast.LENGTH_LONG)
                            .show()
                    }
                    is ViewState.Error -> {
                        Toast.makeText(activity, "Error", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }

}