package com.example.transitionsample.util

import android.app.Activity
import android.os.Build
import android.util.Log
import android.window.OnBackInvokedCallback
import android.window.OnBackInvokedDispatcher
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import com.example.transitionsample.R

/**
 * Activity遷移時のアニメーション
 */
fun Activity.transitionAnimation() {
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
		overrideActivityTransition(
			Activity.OVERRIDE_TRANSITION_OPEN, R.anim.transition_open_enter, R.anim.transition_open_exit
		)
		overrideActivityTransition(
			Activity.OVERRIDE_TRANSITION_CLOSE, R.anim.transition_close_enter, R.anim.transition_close_exit
		)
	}
}



fun Activity.onBackPressedAction(action : () -> Unit){
	    val onBackPressedCallBack = object : OnBackPressedCallback(true) {
	        override fun handleOnBackPressed() {
				Log.d("onBackPressedDispatcher" , "onBackPressed")
				action.invoke()
	        }
	    }
	    (this as ComponentActivity).onBackPressedDispatcher.addCallback(this, onBackPressedCallBack)

	
	//    val transitionSet = TransitionSet().apply {
	//        setOrdering(TransitionSet.ORDERING_SEQUENTIAL)
	//        addTransition(Slide(Gravity.END))
	//        addTransition(ChangeBounds())
	//        addTransition(Fade(Fade.OUT))
	//        setDuration(200L)
	//    }
	//
	//    val onBackPressedCallBack = object : OnBackPressedCallback(true) {
	//        var controller: TransitionSeekController? = null
	//
	//        override fun handleOnBackPressed() {
	//            DebugLog.d("yonemoto", "handleOnBackPressed")
	//            controller?.animateToEnd()
	//            onBackPressed()
	//        }
	//
	//        @RequiresApi(34)
	//        override fun handleOnBackStarted(backEvent : BackEventCompat) {
	//            DebugLog.d("yonemoto", "handleOnBackStarted")
	//            controller = TransitionManager.controlDelayedTransition(
	//                rootView,
	//                transitionSet
	//            )
	//        }
	//
	//        @RequiresApi(34)
	//        override fun handleOnBackProgressed(backEvent : BackEventCompat) {
	//            DebugLog.d("yonemoto", "handleOnBackProgressed")
	//            if (controller?.isReady == true) {
	//                controller?.currentFraction = backEvent.progress
	//            }
	//        }
	//    }
	//    (this as ComponentActivity).onBackPressedDispatcher.addCallback(this, onBackPressedCallBack)
	//
}


fun Activity.registerBackAction(action : () -> Unit): OnBackInvokedCallback? {
	return if(Build.VERSION.SDK_INT >= 34) {
		val onBackInvokeCallback = OnBackInvokedCallback {
			Log.d("onBackInvokeCallback" , "onBackInvoke")
			action.invoke()
		}
		onBackInvokedDispatcher.registerOnBackInvokedCallback(
			OnBackInvokedDispatcher.PRIORITY_DEFAULT,
			onBackInvokeCallback
		)
		
		return onBackInvokeCallback
	} else {
		null
	}
}

fun Activity.unregisterBackAction(callback : OnBackInvokedCallback){
	if(Build.VERSION.SDK_INT >= 34) {
		onBackInvokedDispatcher.unregisterOnBackInvokedCallback(callback)
	}
}