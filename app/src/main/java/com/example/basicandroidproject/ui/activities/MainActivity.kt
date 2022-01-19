package com.example.basicandroidproject.ui.activities

import android.os.Bundle
import com.example.basicandroidproject.R
import com.example.basicandroidproject.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}