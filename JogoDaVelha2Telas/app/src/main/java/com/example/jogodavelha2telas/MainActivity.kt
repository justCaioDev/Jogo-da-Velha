package com.example.jogodavelha2telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    private lateinit var btPlay: Button
    private lateinit var player1: EditText
    private lateinit var player2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        btPlay = findViewById(R.id.bt_play)
        player1 = findViewById(R.id.editText_player1)
        player2 = findViewById(R.id.editText_player2)

        btPlay.setOnClickListener {
            if (player1.text.isEmpty() || player2.text.isEmpty()) {
               Toast.makeText(this, "Insira o nome dos Jogares!", Toast.LENGTH_SHORT)
                   .show()
            } else {
                openGameScreen()
            }
        }
    }

    private fun openGameScreen() {
        val intent = Intent(this, GameScreen::class.java)
        val player1Name = player1.text.toString()
        val player2Name = player2.text.toString()
        intent.putExtra("player1", player1Name)
        intent.putExtra("player2", player2Name)
        startActivity(intent)
    }
}