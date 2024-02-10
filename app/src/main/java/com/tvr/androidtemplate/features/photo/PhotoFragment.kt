package com.tvr.androidtemplate.features.photo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.base.ViewState
import com.tvr.androidtemplate.databinding.FragmentPhotoBinding
import com.tvr.androidtemplate.databinding.FragmentPostBinding
import com.tvr.androidtemplate.features.post.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
@AndroidEntryPoint
class PhotoFragment : Fragment() {
    private lateinit var binding: FragmentPhotoBinding
    private val viewModel: PhotoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotoBinding.inflate(layoutInflater)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.getPhotos()
        observeData()
        return binding.root
    }

    /**
     * observing data from view model
     */
    private fun observeData() {
        lifecycleScope.launch {
            viewModel.data.collect{
                when(it){
                    is ViewState.Loading -> {
                        binding.photoRv.visibility = View.GONE
                        binding.errorTv.visibility = View.GONE
                        binding.postPb.visibility = View.VISIBLE
                    }
                    is ViewState.Success -> {
                        binding.postPb.visibility = View.GONE
                        binding.errorTv.visibility = View.GONE

                        if((it.data?: emptyList()).isEmpty()){
                            binding.errorTv.visibility = View.VISIBLE
                        }else{
                            binding.photoRv.visibility = View.VISIBLE
                        }

                    }
                    is ViewState.Error -> {
                        binding.postPb.visibility = View.GONE
                        binding.photoRv.visibility = View.GONE
                        binding.errorTv.visibility = View.VISIBLE
                        binding.errorTv.text = it.message
                    }
                }
            }
        }
    }
}