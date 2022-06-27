package com.dhana.newsfeedapp

import android.content.Intent
import android.os.Bundle
import com.dhana.newsfeedapp.base.BaseActivity
import com.dhana.newsfeedapp.databinding.ActivityMainBinding
import com.dhana.newsfeedapp.databinding.SplashscreenBinding
import java.util.*

class SplashScreen: BaseActivity<SplashscreenBinding>() {

    override fun setBinding(): SplashscreenBinding = SplashscreenBinding.inflate(layoutInflater)
    private var mtimer: Timer? =null

    override fun onViewReady(savedInstanceState: Bundle?) {
        super.onViewReady(savedInstanceState)
       Timer().schedule(object :TimerTask(){
           override fun run() {
               startActivity(Intent(applicationContext,MainActivity::class.java))
               finish()
           }

       },3*1000)
    }

}