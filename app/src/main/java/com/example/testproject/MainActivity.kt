package com.example.testproject


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson

import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okio.IOException

class MainActivity : AppCompatActivity() {
    // отображение погоды

    lateinit var but : Button
    lateinit var OFC : OurFirstClass
    lateinit var etName : EditText
    lateinit var tv1 :TextView
    lateinit var tv2 : TextView
    var count = 0

    // Создаем OkHttpClient
    private val client = OkHttpClient()

    // Инициализация Gson
    private val gson = Gson()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        but = findViewById(R.id.button)
tv1=findViewById<TextView>(R.id.textView)
        tv2=findViewById(R.id.textView2)
        // Обработчик нажатия кнопки
        but.setOnClickListener {
            Toast.makeText(this, "Запрос погоды", Toast.LENGTH_LONG).show()

            // URL для получения погоды
            val url = "https://api.open-meteo.com/v1/forecast?latitude=55.7522&longitude=37.6156&hourly=temperature_2m"
tv1.text= url
            // Выполняем GET-запрос через OkHttp
            val request = Request.Builder().url(url).build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("Error", "Ошибка сети: ${e.message}")
                }

                override fun onResponse(call: Call, response: Response) {
                    response.body?.string()?.let { jsonResponse ->
                        Log.i("Response", jsonResponse)

                        // Парсим JSON ответ с помощью Gson
                        val weatherData = gson.fromJson(jsonResponse, WeatherResponse::class.java)

                        // Обновляем UI (например, можно вывести данные в TextView)
                        runOnUiThread {
                            Toast.makeText(applicationContext, "Температура: ${weatherData.hourly.temperature_2m[0]}°C", Toast.LENGTH_LONG).show()
                            tv2.text = "Температура: ${weatherData.hourly.temperature_2m[0]}°C в ${weatherData.hourly.time[0]}"
                        }
                    }
                }
            })
        }
    }
    override fun onStart() {
        super.onStart()
        Log.i("FAPP","onStart" )

    }

    override fun onResume() {
        super.onResume()
        Log.i("FAPP","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("FAPP","onPause" )
    }

    override fun onStop() {
        super.onStop()
        Log.i("FAPP","onStop" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("FAPP","onDestroy" )
    }

    fun OurMethod(){

    }
}