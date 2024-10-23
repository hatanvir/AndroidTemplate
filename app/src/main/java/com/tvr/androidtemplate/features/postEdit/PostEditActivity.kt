package com.tvr.androidtemplate.features.postEdit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.data.models.Post
import com.tvr.androidtemplate.databinding.ActivityPostEditBinding
import com.tvr.androidtemplate.features.post.PostViewModel
import com.tvr.androidtemplate.utils.BundleKey
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostEditActivity : AppCompatActivity() {
    lateinit var binding: ActivityPostEditBinding
    private val viewModel: PostEditViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.mutableTitle.value = (intent.getStringExtra(BundleKey.POST) as Post).title
        binding.viewmodel = viewModel
    }
}