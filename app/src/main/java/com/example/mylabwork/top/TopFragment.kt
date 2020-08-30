package com.example.mylabwork.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.mylabwork.databinding.FragmentTopBinding

class TopFragment: Fragment() {

        private lateinit var topViewModel: TopViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            topViewModel = ViewModelProviders.of(this).get(TopViewModel::class.java)
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val binding = FragmentTopBinding.inflate(inflater)
            binding.viewModel = topViewModel

            binding.setLifecycleOwner(this)

            return binding.root
        }
}
