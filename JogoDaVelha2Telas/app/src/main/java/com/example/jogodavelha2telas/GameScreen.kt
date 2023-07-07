package com.example.jogodavelha2telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class GameScreen : AppCompatActivity() {

    private var isPlayer1 = true
    private var gameEnd = false
    //MEIO
    private lateinit var center: ImageView
    private lateinit var centerStart: ImageView
    private lateinit var centerEnd: ImageView
    //TOPO
    private lateinit var top: ImageView
    private lateinit var topStart: ImageView
    private lateinit var topEnd: ImageView
    //BAIXO
    private lateinit var bottom: ImageView
    private lateinit var bottomStart: ImageView
    private lateinit var bottomEnd: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        // MEIO
        center = findViewById(R.id.center)
        centerStart = findViewById(R.id.center_start)
        centerEnd = findViewById(R.id.center_end)
        // TOPO
        top = findViewById(R.id.top)
        topStart = findViewById(R.id.top_start)
        topEnd = findViewById(R.id.top_end)
        // BAIXO
        bottom = findViewById(R.id.bottom)
        bottomStart = findViewById(R.id.bottom_start)
        bottomEnd = findViewById(R.id.bottom_end)

        val btBack = findViewById<Button>(R.id.bt_back)
        val btReset = findViewById<Button>(R.id.reset)

        btReset.setOnClickListener {
            resetBox(center)
            resetBox(centerStart)
            resetBox(centerEnd)

            resetBox(top)
            resetBox(topStart)
            resetBox(topEnd)

            resetBox(bottom)
            resetBox(bottomStart)
            resetBox(bottomEnd)
        }

        btBack.setOnClickListener {
            previusScreen()
        }

        configureBox(center)
        configureBox(centerStart)
        configureBox(centerEnd)

        configureBox(top)
        configureBox(topStart)
        configureBox(topEnd)

        configureBox(bottom)
        configureBox(bottomStart)
        configureBox(bottomEnd)
    }

    private fun resetBox(box: ImageView) {
        box.setImageDrawable(null)
        box.tag = null
        isPlayer1 = true
        gameEnd = false
    }

    private fun configureBox(box: ImageView) {
        val p1Name = intent.getStringExtra("player1")
        val p2Name = intent.getStringExtra("player2")
        box.setOnClickListener {
            if (box.tag == null && !gameEnd) {
                if (isPlayer1) {
                    box.setImageResource(R.drawable.circle)
                    isPlayer1 = false
                    box.tag = 1
                } else {
                    box.setImageResource(R.drawable.close)
                    isPlayer1 = true
                    box.tag = 2
                }
                if (playerWin(1)) {
                    Toast.makeText(this, "$p1Name venceu!", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                } else if (playerWin(2)) {
                    Toast.makeText(this, "$p2Name venceu!", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                }
            }
        }
    }

    private fun previusScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun playerWin(value: Int): Boolean {
        if ((topStart.tag == value && top.tag == value && topEnd.tag == value) ||
            (centerStart.tag == value && center.tag == value && centerEnd.tag == value) ||
            (bottomStart.tag == value && bottom.tag == value && bottomEnd.tag == value) ||

            (topStart.tag == value && centerStart.tag == value && bottomStart.tag == value) ||
            (top.tag == value && center.tag == value && bottom.tag == value) ||
            (topEnd.tag == value && centerEnd.tag == value && bottomEnd.tag == value) ||

            (topStart.tag == value && center.tag == value && bottomEnd.tag == value) ||
            (topEnd.tag == value && center.tag == value && bottomStart.tag == value)
        ) {
            return true
        }
        return false
    }
}