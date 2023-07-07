package com.example.jogodavelha2telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val btPlay = findViewById<Button>(R.id.bt_play)
        val player1 = findViewById<EditText>(R.id.editText_player1)
        val player2 = findViewById<EditText>(R.id.editText_player2)

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
        startActivity(intent)

    }
}