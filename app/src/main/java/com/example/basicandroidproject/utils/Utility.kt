/*
 * Copyright (c) 2022.
 * Created by Ameer Hamza on 19/1/2022
 * Author Ameer Hamza
 */

package com.example.basicandroidproject.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.inputmethod.InputMethodManager
import java.util.*
import java.util.concurrent.TimeUnit

class Utility {

    companion object{
        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }

        fun isValidEmail(email: String?): Boolean {
            return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()
        }

        fun hideKeyboard(context: Activity) {
            val inputManager: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(context.currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }

        fun <T> randomizeArray(array: ArrayList<T>): ArrayList<T> {
            val random = Random()
            for (i in 0 until array.size) {
                val randomPosition: Int = random.nextInt(array.size)
                val temp = array[i]
                array[i] = array[randomPosition]
                array[randomPosition] = temp
            }
            return array
        }

        fun getAppInstallDays(activity: Activity): Int {
            var days: Long = 0
            try {
                val packageManager = activity.packageManager
                val packageInfo = packageManager.getPackageInfo(activity.packageName, PackageManager.GET_PERMISSIONS)
                val timeAgo = Calendar.getInstance().timeInMillis - packageInfo.firstInstallTime
                days = TimeUnit.MILLISECONDS.toDays(timeAgo)
            } catch (e: Exception) {
                Log.d("AppInstallDays", "AppInstallDays error: " + e.message)
            }
            return days.toInt()
        }
    }
}