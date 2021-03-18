package com.elhady.mega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.navigation.Navigation

/**
 * Created by islam elhady on 03/16/2021.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideActionBar()
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp() =
        Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp()

    private fun hideActionBar() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.supportActionBar?.hide()
    }
}