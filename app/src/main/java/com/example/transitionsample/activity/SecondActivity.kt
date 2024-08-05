package com.example.transitionsample.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.transitionsample.databinding.ActivitySecondBinding
import com.example.transitionsample.util.onBackPressedAction
import com.example.transitionsample.util.transitionAnimation

class SecondActivity : BaseActivity() {
	
	private lateinit var binding: ActivitySecondBinding
	
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		
		binding = ActivitySecondBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		binding.button.setOnClickListener {
			val intent = Intent(this, ThirdActivity::class.java)
			startActivity(intent)
		}
	}
}