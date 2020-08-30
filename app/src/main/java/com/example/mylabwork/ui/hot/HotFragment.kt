package com.example.mylabwork.ui.hot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mylabwork.databinding.FragmentHotBinding
import com.example.mylabwork.viewmodels.hot.HotViewModel

class HotFragment : Fragment() {

    private lateinit var hotViewModel: HotViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hotViewModel = ViewModelProvider(this).get(HotViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHotBinding.inflate(inflater)
        binding.viewModel = hotViewModel

        binding.lifecycleOwner = this

        return binding.root
    }
}