package com.example.kolejka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Stack
import java.util.LinkedList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var planets = Stack<String>()
        planets.addAll(listOf("cos1", "cos2", "cos3"))
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
            //Toast.makeText(this, planets.isNotEmpty().toString(), Toast.LENGTH_SHORT).show()

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

        //kolejka
        var txtView2 = findViewById<TextView>(R.id.textView)
        var licznik = findViewById<TextView>(R.id.textView3)
        var kolejka = LinkedList<String>()
        kolejka.addAll(listOf("innecos1", "innecos2", "innecos3"))
        txtView2.text = kolejka.first
        licznik.text = "Długość kolejki: " + kolejka.size
        //przesuwanie kolejki
        findViewById<Button>(R.id.btnAdvance).setOnClickListener {
            if(kolejka.isNotEmpty()){
                kolejka.removeFirst()
                if(kolejka.isEmpty()){
                    txtView2.text = ""
                }
                else{
                    txtView2.text = kolejka.first
                }
            }
            else{
                txtView2.text = ""
            }
            licznik.text = "Długość kolejki: " + kolejka.size
        }
        //dodawanie do kolejki
        findViewById<Button>(R.id.btnAddToQueue).setOnClickListener {
            var txtbox = findViewById<EditText>(R.id.editTextTextPersonName2).text
            kolejka.addLast(txtbox.toString())
            txtView2.text = kolejka.first
            licznik.text = "Długość kolejki: " + kolejka.size
        }
    }
}