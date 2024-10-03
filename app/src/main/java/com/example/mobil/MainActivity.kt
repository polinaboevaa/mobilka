package com.example.mobil

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.`activity_registration`)

        val ponomerubutton = findViewById<TextView>(R.id.ponomeru)
        val poemailbutton = findViewById<TextView>(R.id.poemail)
        val enter = findViewById<EditText>(R.id.enteremail) //введите номер или пароль
        val registration = findViewById<Button>(R.id.registration)
        val password = findViewById<EditText>(R.id.enterparol)
        val passwordrep = findViewById<EditText>(R.id.repeatparol)
        var isEmailPressed = false
        var isNumberPressed = false

        ponomerubutton.setOnClickListener {
            ponomerubutton.setTextColor(Color.parseColor("#ff4f00"))
            poemailbutton.setTextColor(Color.parseColor("#ff9147"))
            enter.hint = "Введите номер"
            enter.setInputType(InputType.TYPE_CLASS_PHONE)
            isNumberPressed = true //нажали кнопку по номеру
            isEmailPressed = false //отжали кнопку по емеил
        }

        poemailbutton.setOnClickListener {
            poemailbutton.setTextColor(Color.parseColor("#ff4f00"))
            ponomerubutton.setTextColor(Color.parseColor("#ff9147"))
            enter.hint = "Введите email"
            enter.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS)
            isNumberPressed = false //отжали кнопку по номеру
            isEmailPressed = true //нажали кнопку по емеил
        }

        registration.setOnClickListener {
            val pass1 = password.text.toString()
            val pass2 = passwordrep.text.toString()
            val text = enter.text.toString()
            if(pass1 != pass2){
                Toast.makeText(this@MainActivity, "Пароли не совпадают", Toast.LENGTH_LONG).show();
            }
            if(pass1.isBlank() or pass2.isBlank() or text.isBlank()){
                Toast.makeText(this@MainActivity, "Заполните все необходимые поля", Toast.LENGTH_LONG).show();
            }
            if(pass1.length < 8){
                Toast.makeText(this@MainActivity, "Пароль должен содержать как минимум 8 символов", Toast.LENGTH_LONG).show();
            }
            if(isNumberPressed){ //если мы во вкладке по номеру
                if(!text.contains("+")){
                    Toast.makeText(this@MainActivity, "Некорректный номер телефона", Toast.LENGTH_LONG).show();
                }
            }
            if(isEmailPressed){
                if(!text.contains("@")){
                    Toast.makeText(this@MainActivity, "Некорректный почтовый адрес", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}