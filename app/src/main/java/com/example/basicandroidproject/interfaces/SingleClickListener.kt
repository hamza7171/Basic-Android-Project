/*
 * Copyright (c) 2022.
 * Created by Ameer Hamza on 19/1/2022
 * Author Ameer Hamza (ameerhamza7171@gmail.com)
 */

package com.example.basicandroidproject.interfaces

import android.os.SystemClock
import android.view.View

/**
* This class will use when we need to stop user for clicking immediately
* */

abstract class SingleClickListener : View.OnClickListener {
    private val minClickInterval: Long = 600
    private var mLastClickTime: Long = 0

    abstract fun onSingleClick(v: View?)

    override fun onClick(v: View?) {
        val currentClickTime = SystemClock.uptimeMillis()
        val elapsedTime = currentClickTime - mLastClickTime
        mLastClickTime = currentClickTime

        if (elapsedTime <= minClickInterval) return
        onSingleClick(v)
    }
}