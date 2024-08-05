package com.example.transitionsample.util

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.transitionsample.R

class Transit {
	companion object {
		fun fade(fragmentManager: FragmentManager): FragmentTransaction {
			return fragmentManager.beginTransaction()
				.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
		}
		
		fun slide(fragmentManager: FragmentManager): FragmentTransaction {
			return fragmentManager.beginTransaction()
				.setCustomAnimations(R.anim.right_to_left_enter, R.anim.right_to_left_exit, R.anim.left_to_right_enter, R.anim.left_to_right_exit)
		}
	}
}