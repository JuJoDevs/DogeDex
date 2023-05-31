package com.jujodevs.dogedex.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jujodevs.dogedex.databinding.ActivityMainBinding
import com.jujodevs.dogedex.domain.model.User
import com.jujodevs.dogedex.ui.auth.LoginActivity
import com.jujodevs.dogedex.ui.settings.SettingsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object{
        fun create(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = User.getLoggedInUser(this)
        if (user == null){
            openLoginActivity()
            return
        }

        binding.settingsFab.setOnClickListener {
            openSettingsActivity()
        }
    }

    private fun openSettingsActivity() {
        startActivity(SettingsActivity.create(this))
    }

    private fun openLoginActivity() {
        startActivity(LoginActivity.create(this))
        finish()
    }
}