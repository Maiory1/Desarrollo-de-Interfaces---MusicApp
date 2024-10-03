package com.example.appmusicaxml

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonPause: ImageButton
    private lateinit var buttonPlay: ImageButton
    private lateinit var imageDisc_2: ImageView
    private lateinit var imageDisc_1: ImageView
    private lateinit var nameMusic_2: TextView
    private lateinit var nameMusic_1: TextView
    private lateinit var buttonAnterior: ImageButton
    private lateinit var buttonSiguiente: ImageButton

    private var changeSong: Boolean = false
    private var reproducir: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        buttonPause = findViewById(R.id.imageButton_Pause)
        buttonPlay = findViewById(R.id.imageButton_Play)
        imageDisc_2 = findViewById(R.id.imageView_Disc2)
        imageDisc_1 = findViewById(R.id.imageView_Disc1)
        nameMusic_2 = findViewById(R.id.textView_NameSong2)
        nameMusic_1 = findViewById(R.id.textView_NameSong)
        buttonAnterior = findViewById(R.id.imageButton_Anterior)
        buttonSiguiente = findViewById(R.id.imageButton_Next)

        imageDisc_1.visibility = View.VISIBLE
        nameMusic_1.visibility = View.VISIBLE

        imageDisc_2.visibility = View.INVISIBLE
        nameMusic_2.visibility = View.INVISIBLE

        buttonPlay.setOnClickListener {
            reproducir = true
            updateButtonVisibility()
        }

        buttonPause.setOnClickListener {
            reproducir = false
            updateButtonVisibility()
        }

        buttonAnterior.setOnClickListener {
            changeSong = true
            updateSongDisc()
        }

        buttonSiguiente.setOnClickListener {
            changeSong = false
            updateSongDisc()
        }
    }

    private fun updateSongDisc() {
        if (!changeSong) {
            imageDisc_2.visibility = View.VISIBLE
            imageDisc_1.visibility = View.INVISIBLE
            nameMusic_2.visibility = View.VISIBLE
            nameMusic_1.visibility = View.INVISIBLE
        } else {
            imageDisc_2.visibility = View.INVISIBLE
            imageDisc_1.visibility = View.VISIBLE
            nameMusic_2.visibility = View.INVISIBLE
            nameMusic_1.visibility = View.VISIBLE
        }
    }

    private fun updateButtonVisibility() {
        if (!reproducir) {
            buttonPause.visibility = View.INVISIBLE
            buttonPlay.visibility = View.VISIBLE
        } else {
            buttonPause.visibility = View.VISIBLE
            buttonPlay.visibility = View.INVISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("reproducir", reproducir)
        outState.putBoolean("changeSong", changeSong)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        reproducir = savedInstanceState.getBoolean("reproducir", false)
        changeSong = savedInstanceState.getBoolean("changeSong", false)
        updateButtonVisibility()
        updateSongDisc()
    }
}
