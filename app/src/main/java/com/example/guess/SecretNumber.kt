package com.example.guess

import java.util.*


class SecretNumber {
    val secretNumber = Random().nextInt(10) + 1
    var count = 0

    fun validate(num: Int): String {
        count++
        val result = num - secretNumber
        val resultText: String
        if (result > 0) {
            resultText = "smaller"
        } else if (result < 0) {
            resultText = "bigger"
        } else {
            resultText = "you got it!"
        }
        return resultText
    }


}