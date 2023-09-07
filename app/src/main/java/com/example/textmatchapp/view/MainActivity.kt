package com.example.textmatchapp.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.textmatchapp.R
import com.example.textmatchapp.databinding.ActivityMainBinding
import com.example.textmatchapp.viewmodel.CompararTextViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CompararTextViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.compareButton.setOnClickListener {
            val text1 = binding.editText1.text.toString()
            val text2 = binding.editText2.text.toString()

            viewModel.compareText(text1, text2)
        }

        viewModel.compareResult.observe(this) { result ->
            binding.resultTextView.text = result
        }
    }
}
