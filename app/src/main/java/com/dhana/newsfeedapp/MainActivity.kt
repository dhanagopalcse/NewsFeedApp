package com.dhana.newsfeedapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dhana.newsfeedapp.base.BaseActivity
import com.dhana.newsfeedapp.databinding.ActivityMainBinding
import com.dhana.newsfeedapp.ui.home.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    val mainViewModel: MainViewModel by viewModels()

    override fun onViewReady(savedInstanceState: Bundle?) {
        super.onViewReady(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Today's News";
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }

        savedInstanceState?.let {
            mainViewModel.hideErrorToast()
        }
    }



    override fun setBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)


    private fun setupBottomNavigationBar() {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_hostfragmentactivity) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_favourite,
                R.id.navigation_settings
            )
        )
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}

