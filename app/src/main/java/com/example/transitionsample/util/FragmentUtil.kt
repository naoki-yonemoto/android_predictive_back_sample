package com.example.transitionsample.util

import android.view.Gravity
import androidx.fragment.app.Fragment
import androidx.transition.*
import androidx.transition.TransitionSet.ORDERING_SEQUENTIAL
import androidx.transition.TransitionSet.ORDERING_TOGETHER

fun Fragment.setTransitAnimation(){
	
	val enterAnim = TransitionSet().apply {
		setOrdering(ORDERING_SEQUENTIAL)
		addTransition(Slide(Gravity.END))
		addTransition(ChangeBounds())
		addTransition(Fade(Fade.OUT))
		setDuration(200L)
	}
	
	val exitAnim = TransitionSet().apply {
		setOrdering(ORDERING_TOGETHER)
		addTransition(Slide(Gravity.START))
		setDuration(200L)
		addTransition(ChangeBounds())
	}
	
	enterTransition = enterAnim
	exitTransition = exitAnim
}