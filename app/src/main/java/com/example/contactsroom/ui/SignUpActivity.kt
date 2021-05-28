package com.example.contactsroom.ui

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.contactsroom.R
import com.example.contactsroom.databinding.ActivitySignUpBinding
import com.example.contactsroom.db.UserRepository
import com.example.contactsroom.db.entities.UserEntity

open class SignUpActivity : AppCompatActivity() {
    private val minPasswordLength = 6
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        userRepository = UserRepository(this)
        binding.signUpBtn.setOnClickListener { saveAccount() }
        binding.logInBtn.setOnClickListener { performLogin() }
    }

    private fun saveAccount() {
            if (validateInput()) {
                val userDetails = UserEntity(emailAdd = binding.etEmail.text.toString(), password = binding.etPassword.text.toString())
                userRepository.upsertUser(userDetails)
                Toast.makeText(this, getString(R.string.success), Toast.LENGTH_SHORT).show()
                val intent = Intent(this, CategoryActivity::class.java)
                startActivity(intent)
                   finish()
            }
        }

    // Checking if the input in form is valid
  private fun validateInput(): Boolean {
        if (binding.etEmail.text.toString() == "") {
            binding.etEmail.error = getString(R.string.pls_email)
            return false
        }
        if (binding.etPassword.text.toString() == "") {
            binding.etPassword.error = getString(R.string.pls_pass)
            return false
        }

        // checking the proper email format
        if (!isEmailValid(binding.etEmail.text.toString())) {
            binding.etEmail.error = getString(R.string.invalid_email)
            return false
        }

        // checking minimum password Length
        if (binding.etPassword.text?.length!! < minPasswordLength) {
            binding.etPassword.error = getString(R.string.invalid_password)
            return false
        }
        return true
    }

    private fun isEmailValid(email: CharSequence): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

   private fun performLogin() {
       val intent = Intent(this, LoginActivity::class.java)
       startActivity(intent)
       finish()
   }
}