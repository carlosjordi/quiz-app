package com.carlosjordi.monthlychallenge03.data.repository

import com.carlosjordi.monthlychallenge03.R
import com.carlosjordi.monthlychallenge03.data.model.Question
import com.carlosjordi.monthlychallenge03.data.model.Quiz

class QuizRepositoryImpl : QuizRepository {

    private val quiz = Quiz(
        listOf(
            Question(R.string.question_01, R.array.answers_01),
            Question(R.string.question_02, R.array.answers_02),
            Question(R.string.question_03, R.array.answers_03),
            Question(R.string.question_04, R.array.answers_04),
            Question(R.string.question_05, R.array.answers_05),
            Question(R.string.question_06, R.array.answers_06),
            Question(R.string.question_07, R.array.answers_07),
            Question(R.string.question_08, R.array.answers_08),
            Question(R.string.question_09, R.array.answers_09),
            Question(R.string.question_10, R.array.answers_10),
            Question(R.string.question_11, R.array.answers_11),
            Question(R.string.question_12, R.array.answers_12),
            Question(R.string.question_13, R.array.answers_13),
            Question(R.string.question_14, R.array.answers_14),
            Question(R.string.question_15, R.array.answers_15),
        )
    )

    override fun getQuiz(): Quiz = quiz
}