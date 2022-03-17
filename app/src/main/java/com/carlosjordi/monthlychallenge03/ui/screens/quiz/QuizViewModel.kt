package com.carlosjordi.monthlychallenge03.ui.screens.quiz

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carlosjordi.monthlychallenge03.data.repository.QuizRepository

class QuizViewModel(
    private val quizRepository: QuizRepository
) : ViewModel() {

    private val quiz = quizRepository.getQuiz()
    private var currentIndex = 0

    var state by mutableStateOf(QuizState(currentQuestion = quiz.questions[currentIndex]))
        private set

    private val timer = object : CountDownTimer(30_000L, 1_000L) {
        override fun onTick(remainingTime: Long) {
            state = state.copy(
                timer = remainingTime
            )
        }

        override fun onFinish() {
            TODO("Not yet implemented")
        }
    }

    init {
        timer.start()
    }

    fun onEvent(event: QuizEvent) {
        when (event) {
            is QuizEvent.SelectOption -> {
                state = state.copy(
                    isOptionSelected = true
                )
            }
            QuizEvent.ConfirmSelection -> {
                timer.cancel()
                currentIndex++
                state = state.copy(
                    currentQuestion = quiz.questions[currentIndex],
                    isOptionSelected = false,
                    timer = 30_000L
                )
                timer.start()
            }
            QuizEvent.TimeRunOut -> TODO()
        }
    }

    class QuizViewModelFactory(
        private val quizRepository: QuizRepository
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
                return QuizViewModel(quizRepository) as T
            }
            throw ClassNotFoundException("QuizViewModel doesn't exist")
        }
    }
}