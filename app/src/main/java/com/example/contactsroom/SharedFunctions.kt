package com.example.contactsroom

import android.util.Patterns

open class SharedFunctions {
    // Checking if the input in form is valid


        fun isEmailValid(email: CharSequence): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()

    }
}