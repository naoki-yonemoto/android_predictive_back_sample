package com.example.transitionsample.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.transitionsample.util.transitionAnimation

open class BaseActivity: AppCompatActivity() {
	
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		transitionAnimation()
	}
	
}