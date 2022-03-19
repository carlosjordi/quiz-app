package com.carlosjordi.monthlychallenge03.ui.screens.quiz

sealed class QuizEvent {
    data class SelectOption(val option: String) : QuizEvent()
    object TimeRunOut : QuizEvent()
}
