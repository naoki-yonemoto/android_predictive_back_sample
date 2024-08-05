package com.example.transitionsample

import android.app.Application
import android.os.Build
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.PredictiveBackControl

class SampleApp: Application() {
	
	@OptIn(PredictiveBackControl::class)
	override fun onCreate() {
		super.onCreate()
		if(Build.VERSION.SDK_INT >= 34) {
			FragmentManager.enablePredictiveBack(true)
		}
		
	}
}