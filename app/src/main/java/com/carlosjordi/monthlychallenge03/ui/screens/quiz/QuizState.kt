package com.carlosjordi.monthlychallenge03.ui.screens.quiz

import com.carlosjordi.monthlychallenge03.data.model.Question
import com.carlosjordi.monthlychallenge03.data.model.Score

data class QuizState(
    val timer: Float = 30f,
    val isOptionSelected: Boolean = false,
    val isRightAnswer: Boolean? = null,
    val currentQuestion: Question,
    val selectedAnswer: String = "",
    val rightAnswer: String = "",
    val score: Score = Score()
)
