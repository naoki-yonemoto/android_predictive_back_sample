package com.example.transitionsample.activity

import android.os.Bundle
import com.example.transitionsample.databinding.ActivityForthBinding

class ForthActivity:BaseActivity() {
	
	private lateinit var binding : ActivityForthBinding
	
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		
		binding = ActivityForthBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
	}
	
	override fun onDestroy() {
		super.onDestroy()
	}
}