package com.carlosjordi.monthlychallenge03.ui.screens.quiz

import com.carlosjordi.monthlychallenge03.data.model.Question

data class QuizState(
    val timer: Int = 30,
    val isOptionSelected: Boolean = false,
    val isRightAnswer: Boolean? = null,
    val currentQuestion: Question,
    val selectedAnswer: String = "",
    val rightAnswer: String = ""
)
