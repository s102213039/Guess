package com.example.guess

import android.content.Context
import java.util.*


class SecretNumber (private val context: Context){
    private val secretNumber = Random().nextInt(10) + 1
    var count = 0

    fun validate(num: Int): String {
        count++
        val result = num - secretNumber
        val resultText: String
        if (result > 0) {
            resultText = context.getString(R.string.smaller)
        } else if (result < 0) {
            resultText = context.getString(R.string.bigger)
        } else {
            resultText = context.getString(R.string.you_got_it)
        }
        return resultText
    }


}