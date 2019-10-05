package com.example.guess

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_record.*

class RecordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        var counter: Int = -1

        intent?.let {
            counter = it.getIntExtra("COUNTER", -1)
        }

        tv_counter.text = counter.toString()

        btn_save.setOnClickListener {
            val nickName = et_nick_name.text.toString()
            getSharedPreferences("guess", Context.MODE_PRIVATE)
                .edit()
                .putInt("REC_COUNTER", counter)
                .putString("REC_NICKNAME",nickName)
                .apply()

            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}
