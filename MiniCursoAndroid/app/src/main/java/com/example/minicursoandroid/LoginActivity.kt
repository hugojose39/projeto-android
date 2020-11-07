package com.example.minicursoandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    companion object {
        const val VALUE_EMAIL = "VALUE_EMAIL"
        const val VALUE_PASSWORD = "VALUE_PASSWORD"
        const val SHARED_NAME = "SHARED_NAME"
        const val SHARED_LOGIN = "SHARED_LOGIN"

    }

    private lateinit var editTextEmail: TextView
    private lateinit var editTextPassword: TextView
    private lateinit var buttonLogin: Button
    private lateinit var textViewError: TextView
    private var passWordUser: String? = null
    private var emailUser: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        editTextEmail = findViewById(R.id.email)
        editTextPassword = findViewById(R.id.senha)
        buttonLogin = findViewById(R.id.login)
        textViewError = findViewById(R.id.text_error)
        buttonLogin.setOnClickListener {

            emailUser = editTextEmail.text.toString()
            passWordUser = editTextPassword.text.toString()

            if (emailUser.isNullOrEmpty() || passWordUser.isNullOrEmpty()) {
                // Toast.makeText( this , "Confira seu email ou senha!" , Toast.LENGTH_SHORT).show()
                textViewError.visibility = View.VISIBLE
            } else {
                saveUserLogin()
                openMainActivy()
            }
        }

        if (getIsLogin()) {
            openMainActivy()
        }
    }

    private fun saveUserLogin() {
        val sharedPreferences = this.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
                ?: return
        sharedPreferences.edit().putBoolean(SHARED_LOGIN, true).apply()
    }

    private fun getIsLogin(): Boolean {
        val sharedPreferences = this.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE) ?: return false

        return sharedPreferences.getBoolean(SHARED_LOGIN, false)
    }
    private fun openMainActivy() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(VALUE_EMAIL, emailUser)
            putExtra(VALUE_PASSWORD, passWordUser)


        }
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }


}