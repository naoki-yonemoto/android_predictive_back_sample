package com.example.transitionsample.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.window.OnBackInvokedCallback
import com.example.transitionsample.R
import com.example.transitionsample.databinding.FragmentThirdBinding
import com.example.transitionsample.util.Transit
import com.example.transitionsample.util.registerBackAction
import com.example.transitionsample.util.unregisterBackAction

class ThirdFragment: BaseFragment() {
	
	private var _binding : FragmentThirdBinding? = null
	private val binding get() = _binding!!
	private var backPressedCallback : OnBackInvokedCallback? = null
	
	override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?, savedInstanceState : Bundle?) : View {
		super.onCreateView(inflater, container, savedInstanceState)
		_binding = FragmentThirdBinding.inflate(inflater, container, false)
		return binding.root
	}
	
	override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		binding.button.setOnClickListener {
			Transit.slide(parentFragmentManager)
				.replace(R.id.container, ForthFragment())
				.addToBackStack("third")
				.commit()
		}
		
		backPressedCallback = registerBackAction {
			Log.d("ThirdFragment", "onBack")
		}
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		backPressedCallback?.let {
			unregisterBackAction(it)
		}
		_binding = null
	}
}