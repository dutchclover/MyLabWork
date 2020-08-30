package com.example.mylabwork.hot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.mylabwork.databinding.FragmentHotBinding

class HotFragment: Fragment() {

    private lateinit var hotViewModel: HotViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hotViewModel = ViewModelProviders.of(this).get(HotViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHotBinding.inflate(inflater)
        binding.viewModel = hotViewModel

        binding.setLifecycleOwner(this)

        return binding.root
    }
}