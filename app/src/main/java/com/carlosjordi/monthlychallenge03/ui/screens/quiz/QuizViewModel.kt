package com.carlosjordi.monthlychallenge03.ui.screens.quiz

import android.os.CountDownTimer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringArrayResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.carlosjordi.monthlychallenge03.data.repository.QuizRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuizViewModel(
    private val quizRepository: QuizRepository
) : ViewModel() {

    companion object {
        private const val TIMER = 30_000L
        private const val ONE_SECOND = 1_000L
    }

    private val quiz = quizRepository.getQuiz()
    private var currentIndex = 0

    var state by mutableStateOf(QuizState(currentQuestion = quiz.questions[currentIndex]))
        private set

    private val timer = object : CountDownTimer(TIMER, ONE_SECOND) {
        override fun onTick(remainingTime: Long) {
            val timeInSeconds = (remainingTime / ONE_SECOND).toInt()
            state = state.copy(
                timer = timeInSeconds
            )
        }

        override fun onFinish() {

        }
    }

    init {
        timer.start()
    }

    fun onEvent(event: QuizEvent) {
        when (event) {
            is QuizEvent.SelectOption -> {
                state = state.copy(
                    isOptionSelected = true,
                    selectedAnswer = event.option
                )
            }
            QuizEvent.ConfirmSelection -> {
                viewModelScope.launch {
                    timer.cancel()
                    state = if (state.selectedAnswer == state.rightAnswer) {
                        state.copy(isRightAnswer = true)
                    } else {
                        state.copy(isRightAnswer = false)
                    }
                    delay(2000L)
                    currentIndex++
                    state = state.copy(
                        currentQuestion = quiz.questions[currentIndex],
                        isOptionSelected = false,
                        timer = 30,
                        isRightAnswer = null
                    )
                    timer.start()
                }
            }
            QuizEvent.TimeRunOut -> TODO()
        }
    }

    fun shuffleAnswers(answers: Array<String>): List<String> {
        // first answer is the right one, so we save it before the shuffle
        state = state.copy(rightAnswer = answers[0])
        return answers.toList().shuffled()
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