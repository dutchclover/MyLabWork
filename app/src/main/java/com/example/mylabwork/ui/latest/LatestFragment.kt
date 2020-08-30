package com.example.mylabwork.ui.latest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mylabwork.databinding.FragmentLatestBinding
import com.example.mylabwork.viewmodels.latest.LatestViewModel

class LatestFragment : Fragment() {

    private lateinit var latestViewModel: LatestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        latestViewModel = ViewModelProvider(this).get(LatestViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLatestBinding.inflate(inflater)
        binding.viewModel = latestViewModel

        binding.lifecycleOwner = this

        return binding.root
    }
}