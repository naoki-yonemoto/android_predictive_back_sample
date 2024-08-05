package com.example.transitionsample.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.window.OnBackInvokedCallback
import com.example.transitionsample.databinding.ActivityThirdBinding
import com.example.transitionsample.util.onBackPressedAction
import com.example.transitionsample.util.registerBackAction
import com.example.transitionsample.util.unregisterBackAction

class ThirdActivity : BaseActivity() {
	
	private lateinit var binding : ActivityThirdBinding
	private var backPressedCallback : OnBackInvokedCallback? = null
	
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		
		binding = ActivityThirdBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		binding.button.setOnClickListener {
			val intent = Intent(this, ForthActivity::class.java)
			startActivity(intent)
		}
		
		backPressedCallback = registerBackAction {
			onBack()
		}
	}
	
	override fun onDestroy() {
		super.onDestroy()
		backPressedCallback?.let {
			unregisterBackAction(it)
		}
	}
	
	 private fun onBack(){
		Log.d("ThirdActivity", "onBackInvoked")
		finish()
	}
}