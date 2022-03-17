package com.carlosjordi.monthlychallenge03.data.repository

import com.carlosjordi.monthlychallenge03.R
import com.carlosjordi.monthlychallenge03.data.model.Question
import com.carlosjordi.monthlychallenge03.data.model.Quiz

class QuizRepositoryImpl : QuizRepository {

    private val quiz = Quiz(
        listOf(
            Question(R.string.question_01, R.array.answers_01),
            Question(R.string.question_02, R.array.answers_02),
        )
    )

    override fun getQuiz(): Quiz = quiz
}