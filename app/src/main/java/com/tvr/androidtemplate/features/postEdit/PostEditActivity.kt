package com.tvr.androidtemplate.features.postEdit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.databinding.ActivityPostEditBinding

class PostEditActivity : AppCompatActivity() {
    lateinit var binding: ActivityPostEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}