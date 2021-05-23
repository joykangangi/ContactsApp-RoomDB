package com.example.contactsroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactsroom.databinding.ActivityLoginBinding
import com.example.contactsroom.databinding.ActivitySignUpBinding

class LoginActivity : AppCompatActivity() {
    private val minPasswordLength = 6
private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}