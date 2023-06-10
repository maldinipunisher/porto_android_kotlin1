package com.example.porto_native1.Controller

import android.os.StrictMode
import com.example.porto_native1.models.Token
import com.example.porto_native1.models.Users
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class AuthController {
    fun login(email: String, password: String): Token? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var result : Token? = null;
        var reqParam = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8")
        reqParam += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")
        val mURL = URL("https://reqres.in/api/login")

        with(mURL.openConnection() as HttpURLConnection) {
            // optional default is GET
            requestMethod = "POST"

            val wr = OutputStreamWriter(getOutputStream());
            wr.write(reqParam);
            wr.flush();

            println("URL : $url")
            println("Response Code : $responseCode")

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()
                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                result=Json.decodeFromString<Token>(response.toString());
            }
        }
        return result;
    }
}