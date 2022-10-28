package com.example.kolejka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Stack

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var planets = Stack<String>()
        planets.addAll(listOf("Mercury"))
        findViewById<TextView>(R.id.txt1).text = planets.peek()
        var txtView = findViewById<TextView>(R.id.txt1)

        //dodawanie do stosu
        findViewById<Button>(R.id.button6).setOnClickListener {
            var txtbox = findViewById<EditText>(R.id.editTextTextPersonName)
            planets.push(txtbox.text.toString())
            txtView.text = planets.peek()
        }
        //usuwanie ze stosu
        findViewById<Button>(R.id.button2).setOnClickListener {
            Toast.makeText(this, planets.isNotEmpty().toString(), Toast.LENGTH_SHORT).show()

            if(planets.isNotEmpty()){
                planets.pop()
                if(planets.isEmpty()){
                    txtView.text = ""
                }
                else{
                    txtView.text = planets.peek()
                }
            }
            else{
                txtView.text = ""
            }
        }
    }
}