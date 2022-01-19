package com.example.basicandroidproject.base

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.basicandroidproject.interfaces.ClickListener
import com.example.basicandroidproject.interfaces.DataListener

class BaseFragment : Fragment() {

    var dataListener: DataListener? = null
    var clickListener: ClickListener? = null

    fun showLog(message: String, tag: String = "TAG") {
        Log.d(tag, "log message: $message")
    }

    fun doWorkWithDelay(delay: Long, callback: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({
            callback()
        }, delay)
    }

    fun showToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }
}