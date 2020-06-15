package com.thedroidcamp.qvid19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var currentScore : Int = 0
    var q1Answered : Boolean = false
    var q2Answered : Boolean = false
    var q3Answered : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun calculateScore(newScore : Int) {
        currentScore += newScore
    }

    public fun getScore() : Int {
        return currentScore
    }

    public fun setAnswered(questionId: Int) {
        when (questionId) {
            1 -> q1Answered = true
            2 -> q2Answered = true
            3 -> q3Answered = true
            // you can add other answer accordingly
        }
    }


}