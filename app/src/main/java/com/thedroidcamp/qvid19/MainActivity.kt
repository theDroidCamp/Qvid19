package com.thedroidcamp.qvid19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thedroidcamp.qvid19.data.QNA

class MainActivity : AppCompatActivity() {

    var currentScore : Int = 0
    var q1Answered : Boolean = false
    var q2Answered : Boolean = false
    var q3Answered : Boolean = false
    var q4Answered: Boolean = false

    var qnaList : ArrayList<QNA> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculateScore(newScore : Int) {
        currentScore += newScore
    }

    fun getScore() : Int {
        return currentScore
    }

    fun setAnswered(questionId: Int, checkedAnswerId : Int) {
        setQNA(questionId, checkedAnswerId)
    }
    fun setAnswered(questionId: Int) {
        when (questionId) {
            1 -> q1Answered = true
            2 -> q2Answered = true
            3 -> q3Answered = true
            4 -> q4Answered = true
            // you can add other answer accordingly
        }
    }

    private fun setQNA(questionId: Int, checkedAnswerId: Int): Boolean {
        qnaList.add(questionId-1, QNA(questionId = questionId, answerId = checkedAnswerId))
        //q1Answered = true
        setAnswered(questionId)
        return true
    }

    fun clearQNAs() {
        qnaList.clear() // to clear user selections
        currentScore = 0 // clear score
        q1Answered= false
        q2Answered= false
        q3Answered= false
        q4Answered= false
        // you can add other answer accordingly
    }


}