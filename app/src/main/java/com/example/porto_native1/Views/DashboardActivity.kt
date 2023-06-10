package com.example.porto_native1.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.porto_native1.Controller.UserController
import com.example.porto_native1.R

class DashboardActivity constructor() : AppCompatActivity() {
    val userController: UserController = UserController();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val result = userController.getUsers("https://reqres.in/api/users?page=2");
        if (result != null) {
            val users = result.data;
            val listView: ListView = findViewById<ListView>(R.id.users_list);
            val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                users.map { item -> item.first_name });

            listView.adapter = adapter;
        }
    }
}