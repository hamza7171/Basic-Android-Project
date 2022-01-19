package com.example.basicandroidproject.base

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.basicandroidproject.interfaces.DataListener
import com.google.android.material.snackbar.Snackbar

open class BaseActivity : AppCompatActivity() {

    var dataListener: DataListener? = null


    fun showLog(message: String, tag: String = "TAG") {
        Log.d(tag, "log message: $message")
    }

    fun showSnackBar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
    }

    fun doWorkWithDelay(delay: Long, callback: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({
            callback()
        }, delay)
    }
}