package com.example.porto_native1.Controller

import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import com.example.porto_native1.models.Users
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.serialization.json.Json

//{
//    "data": {
//    "id": 2,
//    "email": "janet.weaver@reqres.in",
//    "first_name": "Janet",
//    "last_name": "Weaver",
//    "avatar": "https://reqres.in/img/faces/2-image.jpg"
//},
//    "support": {
//    "url": "https://reqres.in/#support-heading",
//    "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
//}
//}

class UserController {

    fun getUsers(url:String): Users? {
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var result : Users? = null;
        val url = URL(url);
        with(url.openConnection() as HttpURLConnection)  {
            requestMethod = "GET";
            println("sending to $url with GET method") ;
            inputStream.bufferedReader().use {
                it.lines().forEach{line ->
                    result = Json.decodeFromString<Users>(line);
                };
            }
        }
        return result;
    }
}