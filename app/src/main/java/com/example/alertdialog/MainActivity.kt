package com.example.alertdialog


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {
    private lateinit var showButton:Button
    lateinit var tvText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alertDialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.alert_dialog,null)
        alertDialog.setView(dialogView)

        val etText = dialogView.findViewById<EditText>(R.id.etText)
        val tvDisplay = dialogView.findViewById<TextView>(R.id.tvDisplay)
        val tvButton = dialogView.findViewById<Button>(R.id.tvButton)
        val goButton = dialogView.findViewById<Button>(R.id.goButton)

        showButton = findViewById(R.id.showButton)

        showButton.setOnClickListener {
            tvButton.setOnClickListener {
                tvDisplay.text = etText.text.toString()
            }
            goButton.setOnClickListener {
                startActivity(Intent(this,MainActivity2::class.java)
                    .putExtra
                ("data",etText.text.toString()))
            }
            alertDialog.show()
        }
    }
}