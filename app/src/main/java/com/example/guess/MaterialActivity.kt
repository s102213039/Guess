package com.example.guess

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_material.*
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {

    private val REQUEST_RECORD: Int = 100
    var secretNumber = SecretNumber(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
            replay(secretNumber)
        }
        tv_counter.text = secretNumber.count.toString()

        btn_validate.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_title))
                .setMessage(secretNumber.validate(ed_number.text.toString().toInt()))
                .setPositiveButton(getString(R.string.ok), { dialog, which ->
                    if (secretNumber.secretNumber.equals(ed_number.text.toString().toInt())) {
                        val intent = Intent(MaterialActivity@ this, RecordActivity::class.java)
                        intent.putExtra("COUNTER", secretNumber.count)
                        startActivityForResult(intent, REQUEST_RECORD)
                    }
                })
                .show()
            tv_counter.text = secretNumber.count.toString()
        }
    }

    private fun replay(secretNumber: SecretNumber) {
        AlertDialog.Builder(this)
            .setTitle("Replay Game")
            .setMessage("Are You Sure?")
            .setPositiveButton(getString(R.string.ok), { dialog, which ->
                secretNumber.reset()
                tv_counter.text = secretNumber.count.toString()
                ed_number.setText("")
            })
            .setNeutralButton("Cancel", null)
            .show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_RECORD -> {
                    secretNumber = SecretNumber(this)
                    replay(secretNumber)
                }
            }
        }
    }
}
