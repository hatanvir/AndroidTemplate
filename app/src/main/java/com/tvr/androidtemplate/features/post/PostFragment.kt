package com.tvr.androidtemplate.features.post

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.base.ViewState
import com.tvr.androidtemplate.databinding.ActivityHomeBinding
import com.tvr.androidtemplate.databinding.FragmentPostBinding
import com.tvr.androidtemplate.features.home.HomeViewModel
import com.tvr.androidtemplate.features.post.adapters.PostRecyclerviewAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
@AndroidEntryPoint
class PostFragment : Fragment() {
    private lateinit var binding: FragmentPostBinding
    private val viewModel: PostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostBinding.inflate(layoutInflater)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.getPost()
        observeData()
        observeNavigation()
        return binding.root;
    }

    /**
     * observe this fragment navigation here
     */
    private fun observeNavigation() {
        lifecycleScope.launch {
            viewModel.navigation.collect{
                when (it){
                    R.id.action_PostFragment_to_PostEditActivity -> {
                        findNavController().navigate(it)
                        viewModel.navigation.value = 0
                    }
                }
            }
        }
    }

    /**
     * observing data from view model
     */
    private fun observeData() {
        lifecycleScope.launch {
            viewModel.data.collect{
                when(it){
                    is ViewState.Loading -> {
                        binding.postRv.visibility = View.GONE
                        binding.errorTv.visibility = View.GONE
                        binding.postPb.visibility = View.VISIBLE
                    }
                    is ViewState.Success -> {
                        binding.postPb.visibility = View.GONE
                        binding.errorTv.visibility = View.GONE

                        //checking our list is empty or not
                        //if empty then show empty text
                        if((it.data?: emptyList()).isEmpty()){
                            binding.errorTv.visibility = View.VISIBLE
                        }else{
                            binding.postRv.visibility = View.VISIBLE
                        }

                    }
                    is ViewState.Error -> {
                        binding.postPb.visibility = View.GONE
                        binding.postRv.visibility = View.GONE
                        binding.errorTv.visibility = View.VISIBLE
                        binding.errorTv.text = it.message
                    }
                }
            }
        }
    }
}