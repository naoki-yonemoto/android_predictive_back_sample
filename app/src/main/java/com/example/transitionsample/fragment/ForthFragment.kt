package com.example.transitionsample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.transitionsample.databinding.FragmentForthBinding

class ForthFragment:BaseFragment() {
	
	private var _binding : FragmentForthBinding? = null
	private val binding get() = _binding!!
	
	override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?, savedInstanceState : Bundle?) : View? {
		super.onCreateView(inflater, container, savedInstanceState)
		_binding = FragmentForthBinding.inflate(inflater, container, false)
		return binding.root
	}
	
	override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
		super.onViewCreated(view, savedInstanceState)
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}