package com.example.porto_native1.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.porto_native1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getStartedBtn : Button = findViewById(R.id.btn_get_started);
        getStartedBtn.setOnClickListener {
            val loginPage:Intent = Intent(this, LoginActivity::class.java);
            startActivity(loginPage);
        }


    }


}