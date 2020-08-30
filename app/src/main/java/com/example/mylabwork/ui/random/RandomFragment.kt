package com.example.mylabwork.ui.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mylabwork.databinding.FragmentRandomBinding
import com.example.mylabwork.viewmodels.random.RandomViewModel

class RandomFragment : Fragment() {

    private lateinit var randomViewModel: RandomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       randomViewModel = ViewModelProvider(this).get(RandomViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRandomBinding.inflate(inflater)
        binding.viewModel = randomViewModel

        binding.lifecycleOwner = this

        return binding.root
    }
}