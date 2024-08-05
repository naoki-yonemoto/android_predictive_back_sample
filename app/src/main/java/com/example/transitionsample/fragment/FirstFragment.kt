package com.example.transitionsample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.transitionsample.R
import com.example.transitionsample.databinding.FragmentFirstBinding
import com.example.transitionsample.util.Transit

class FirstFragment: BaseFragment() {
	
	private var _binding : FragmentFirstBinding? = null
	private val binding get() = _binding!!
	
	override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?, savedInstanceState : Bundle?) : View {
		super.onCreateView(inflater, container, savedInstanceState)
		_binding = FragmentFirstBinding.inflate(inflater, container, false)
		return binding.root
	}
	
	override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		binding.button.setOnClickListener {
			Transit.slide(parentFragmentManager)
				.replace(R.id.container, SecondFragment())
				.addToBackStack("second")
				.commit()
		}
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}