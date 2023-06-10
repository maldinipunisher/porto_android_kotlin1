package com.example.porto_native1.Views

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.porto_native1.Controller.AuthController
import com.example.porto_native1.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    private val authController : AuthController = AuthController();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val clipboard : ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager;

        val buttonCloseLogin: Button = findViewById(R.id.btn_close_login);
        buttonCloseLogin.setOnClickListener{
            println("Clicked");
            startActivity(Intent(this, MainActivity::class.java));
        }

        val emailCopy : TextView = findViewById(R.id.email_copy);
        emailCopy.setOnClickListener {
            clipboard.setPrimaryClip(ClipData.newPlainText("Copied to clipboard", "eve.holt@reqres.in"));
        }

        val passwordCopy : TextView = findViewById(R.id.password_copy);
        passwordCopy.setOnClickListener {
            clipboard.setPrimaryClip(ClipData.newPlainText("Copied to clipboard", "cityslicka"));
        }

        val btnLogin: Button = findViewById(R.id.btn_login_login);
        btnLogin.setOnClickListener {
            println(findViewById<EditText>(R.id.login_email).text.toString());
            val result = authController.login(email = findViewById<EditText>(R.id.login_email).text.toString(), password = findViewById<TextInputEditText>(
                R.id.login_password
            ).text.toString());
            if(result !=null ) {
                startActivity(Intent(this, DashboardActivity::class.java));
            }
        }
    }
}