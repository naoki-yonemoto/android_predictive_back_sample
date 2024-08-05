package com.example.transitionsample.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.transitionsample.activity.FragmentContainerActivity
import com.example.transitionsample.activity.ThirdActivity
import com.example.transitionsample.util.setTransitAnimation

open class BaseFragment : Fragment() {
	
	override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?, savedInstanceState : Bundle?) : View? {
		setTransitAnimation()
		return super.onCreateView(inflater, container, savedInstanceState)
	}
}