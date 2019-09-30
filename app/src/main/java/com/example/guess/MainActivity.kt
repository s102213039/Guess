package com.example.guess

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secretNumber = SecretNumber(this)


        btn_validate.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_title))
                .setMessage(secretNumber.validate(ed_number.text.toString().toInt()))
                .setPositiveButton(getString(R.string.ok), null)
                .show()
        }

    }
}
