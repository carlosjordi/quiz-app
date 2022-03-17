package com.carlosjordi.monthlychallenge03.ui.screens.quiz

import com.carlosjordi.monthlychallenge03.data.model.Question
import com.carlosjordi.monthlychallenge03.data.model.Quiz
import com.carlosjordi.monthlychallenge03.data.repository.QuizRepositoryImpl

data class QuizState(
//    val quiz: Quiz = QuizRepositoryImpl().getQuiz(),
    val timer: Long = 30_000L,
    val isOptionSelected: Boolean = false,
    val isRightAnswer: Boolean = false,
    val currentQuestion: Question
)
