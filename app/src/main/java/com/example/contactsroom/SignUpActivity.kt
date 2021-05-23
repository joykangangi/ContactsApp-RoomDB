package com.example.contactsroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.contactsroom.databinding.ActivitySignUpBinding

open class SignUpActivity : AppCompatActivity() {
    private val minPasswordLength = 6
    private var binding: ActivitySignUpBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.signUpBtn?.setOnClickListener {  performLogin()  }
    }


    // Checking if the input in form is valid
     fun validateInput(): Boolean {
        if (binding?.etEmail?.text.toString() == "") {
            binding?.etEmail?.error = getString(R.string.pls_email)
            return false
        }
        if (binding?.etPassword?.text.toString() == "") {
            binding?.etPassword?.error = getString(R.string.pls_pass)
            return false
        }

        // checking the proper email format
        if (!isEmailValid(binding?.etEmail?.text.toString())) {
            binding?.etEmail?.error = getString(R.string.invalid_email)
            return false
        }

        // checking minimum password Length
        if (binding?.etPassword?.text?.length!! < minPasswordLength) {
            binding?.etPassword?.error = "Password Length must be more than " + minPasswordLength+ "characters"
            return false
        }
        return true
    }

     fun isEmailValid(email: CharSequence): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Hook Click Event
   private  fun performLogin() {
        if (validateInput()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Sign Up Success", Toast.LENGTH_SHORT).show()

        }
    }



    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}