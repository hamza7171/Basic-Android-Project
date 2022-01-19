package com.example.basicandroidproject.ui.activities

import android.content.Intent
import android.os.Bundle
import com.example.basicandroidproject.R
import com.example.basicandroidproject.base.BaseActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        moveToNextScreen()
    }

    private fun moveToNextScreen() {
        doWorkWithDelay(2000) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}