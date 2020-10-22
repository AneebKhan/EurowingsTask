package com.maddbrains.eurowingstask.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.maddbrains.eurowingstask.R
import com.maddbrains.eurowingstask.presentation.feed.FeedActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, FeedActivity::class.java))
            finish()
        }, 3000)
    }
}