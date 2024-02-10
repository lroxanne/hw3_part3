package com.example.hw3_part3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val simpleSeekBar1 = findViewById<SeekBar>(R.id.simpleSeekBar1)
        val simpleSeekBar2 = findViewById<SeekBar>(R.id.simpleSeekBar2)
        val textViewC = findViewById<TextView>(R.id.C)
        val textViewF = findViewById<TextView>(R.id.F)
        val messageTextView = findViewById<TextView>(R.id.message)
        simpleSeekBar1.max =100
        simpleSeekBar2.max = 212

        // Listener for simpleSeekBar1
        simpleSeekBar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    val fahrenheit = (progress * 9 / 5) + 32
                    simpleSeekBar2.progress = fahrenheit - 32 // Adjust for SeekBar's range
                    textViewC.text = "$progress°C"
                    textViewF.text = "${fahrenheit}°F"
                    updateMessage(progress, messageTextView)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        simpleSeekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    var fahrenheit = progress + 32
                    if (fahrenheit < 32) {
                        fahrenheit = 32
                        seekBar?.progress = 0
                    }
                    val celsius = (fahrenheit - 32) * 5 / 9
                    simpleSeekBar1.progress = celsius
                    textViewC.text = "$celsius°C"
                    textViewF.text = "$fahrenheit°F"
                    updateMessage(celsius, messageTextView)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

    }

}

private fun updateMessage(celsius: Int, messageTextView: TextView) {
    messageTextView.text = if (celsius <= 20) "I wish it were warmer." else "I wish it were colder."
}
