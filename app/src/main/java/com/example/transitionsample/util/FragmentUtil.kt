package com.example.transitionsample.util

import android.util.Log
import android.view.Gravity
import android.window.OnBackInvokedCallback
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
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

fun Fragment.onBackAction(action : () -> Unit) {
	
	requireActivity().onBackPressedDispatcher.addCallback(this) {
		if (parentFragmentManager.backStackEntryCount > 0) {
			action.invoke()
			Log.d("Fragment.onBackPressedDispatcher", "popBackStack")
			parentFragmentManager.popBackStack()
		}
	}
}

fun Fragment.registerBackAction(action : () -> Unit): OnBackInvokedCallback {
	val onBackInvokeCallback = OnBackInvokedCallback {
		if (parentFragmentManager.backStackEntryCount >= 1) {
			Log.d("Fragment.onBackInvokedDispatcher", "popBackStack")
			action.invoke()
			parentFragmentManager.popBackStack()
		}
	}
	
	requireActivity().onBackInvokedDispatcher.registerOnBackInvokedCallback(
		OnBackInvokedDispatcher.PRIORITY_DEFAULT,
		onBackInvokeCallback
	)
	
	return onBackInvokeCallback
	
}

fun Fragment.unregisterBackAction(callBack: OnBackInvokedCallback){
	requireActivity().onBackInvokedDispatcher.unregisterOnBackInvokedCallback(callBack)
}
