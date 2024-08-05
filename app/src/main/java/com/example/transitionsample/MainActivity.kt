package com.example.transitionsample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.transitionsample.activity.BaseActivity
import com.example.transitionsample.activity.SecondActivity
import com.example.transitionsample.activity.FragmentContainerActivity
import com.example.transitionsample.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
	
	private lateinit var binding: ActivityMainBinding
	
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		binding.button.setOnClickListener {
			val intent = Intent(this, SecondActivity::class.java)
			startActivity(intent)
		}
		
		binding.button2.setOnClickListener {
			val intent = Intent(this, FragmentContainerActivity::class.java)
			startActivity(intent)
		}
	}
}
