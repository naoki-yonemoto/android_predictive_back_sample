package com.example.transitionsample.activity

import android.os.Bundle
import android.util.Log
import android.window.OnBackInvokedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.transitionsample.databinding.ActivityFragmentContainerBinding
import com.example.transitionsample.util.onBackPressedAction
import com.example.transitionsample.util.registerBackAction
import com.example.transitionsample.util.transitionAnimation
import com.example.transitionsample.util.unregisterBackAction

class FragmentContainerActivity: AppCompatActivity() {
	
	private lateinit var binding : ActivityFragmentContainerBinding
	private var backPressedCallback : OnBackInvokedCallback? = null
	
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		transitionAnimation()
		
		binding = ActivityFragmentContainerBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		backPressedCallback = registerBackAction {
			onBack()
		}
	}
	
	 private fun onBack(){
		Log.d("FragmentContainerActivity", "onBack()")
		 if(supportFragmentManager.backStackEntryCount >= 1){
			 Log.d("FragmentContainerActivity", "popBackStack")
			 supportFragmentManager.popBackStack()
		 } else {
			 Log.d("FragmentContainerActivity", "finish")
			 finish()
		 }
	}
	
	override fun onDestroy() {
		super.onDestroy()
		backPressedCallback?.let {
			unregisterBackAction(it)
		}
	}
}