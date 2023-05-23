package com.tieuvy.android.base_mvvm_android_1.utils.extension

import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavGraph

private const val TAG = "NavigationExtension"
fun NavController.navigateSafe(direction: NavDirections) {
    try {
        val currentDestination = this.currentDestination
        currentDestination?.let {
            val navAction = it.getAction(direction.actionId)
            if (navAction != null) {
                val destinationId = navAction.destinationId
                val currentNode =
                    if (currentDestination is NavGraph)
                        currentDestination
                    else currentDestination.parent
                currentNode?.findNode(destinationId)?.let {
                    this.navigate(direction)
                }
            }
        }
    }catch (ex: Exception){
        Log.e(TAG, "navigateSafe: ${ex.message}", )
    }
}

fun NavController.navigateSafe(@IdRes resId: Int, args: Bundle? = null) {
    try {
        val currentDestination = this.currentDestination
        currentDestination?.let {
            val navAction = it.getAction(resId)
            if (navAction != null) {
                val destinationId = navAction.destinationId
                val currentNode =
                    if (currentDestination is NavGraph)
                        currentDestination
                    else currentDestination.parent

                currentNode?.findNode(destinationId)?.let {
                    this.navigate(resId, args)
                }
            }
        }
    }catch (ex : Exception) {
        Log.e(TAG, "navigateSafe: ${ex.message}", )
    }
}

fun NavController.popBackStackSafe(@IdRes resId: Int) {
    if(popBackStack().not()){
        navigateSafe(resId)
    }
}