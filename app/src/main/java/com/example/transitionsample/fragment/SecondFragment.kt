package com.example.transitionsample.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.transitionsample.activity.ThirdActivity
import com.example.transitionsample.databinding.FragmentSecondBinding
import com.example.transitionsample.util.onBack
import com.example.transitionsample.util.onBackPressedAction

class SecondFragment : BaseFragment() {
	
	private var _binding : FragmentSecondBinding? = null
	private val binding get() = _binding!!
	
	
	override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?, savedInstanceState : Bundle?) : View {
		_binding = FragmentSecondBinding.inflate(inflater, container, false)
		return binding.root
	}
	
	override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		onBack {
			Log.d("SecondFragment", "onBackPressed()")
		}
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}