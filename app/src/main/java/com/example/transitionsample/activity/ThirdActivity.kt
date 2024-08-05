package com.example.transitionsample.activity

import android.os.Bundle
import android.util.Log
import com.example.transitionsample.databinding.ActivityThirdBinding
import com.example.transitionsample.util.onBackPressedAction

class ThirdActivity : BaseActivity() {
	
	private lateinit var binding : ActivityThirdBinding
	
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		
		binding = ActivityThirdBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		onBackPressedAction {
			onBack()
		}
	}
	
	 fun onBack(){
		Log.d("ThirdActivity", "onBackPressed CallBack")
		finish()
	}
}