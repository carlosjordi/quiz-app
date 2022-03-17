package com.carlosjordi.monthlychallenge03.ui.screens.quiz

import com.carlosjordi.monthlychallenge03.data.model.Question
import com.carlosjordi.monthlychallenge03.data.model.Quiz
import com.carlosjordi.monthlychallenge03.data.repository.QuizRepositoryImpl

data class QuizState(
//    val quiz: Quiz = QuizRepositoryImpl().getQuiz(),
    val timer: Int = 30,
    val isOptionSelected: Boolean = false,
    val isRightAnswer: Boolean? = null,
    val currentQuestion: Question
)
