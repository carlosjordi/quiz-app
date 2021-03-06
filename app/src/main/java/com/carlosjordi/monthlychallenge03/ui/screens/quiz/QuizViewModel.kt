package com.carlosjordi.monthlychallenge03.ui.screens.quiz

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosjordi.monthlychallenge03.data.repository.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
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

    private val _navigateToSaveScore = MutableSharedFlow<Int>()
    val navigateToSaveScore = _navigateToSaveScore.asSharedFlow()

    private val timer = object : CountDownTimer(TIMER, ONE_SECOND) {
        override fun onTick(remainingTime: Long) {
            val timeInSeconds = (remainingTime / ONE_SECOND).toFloat()
            state = state.copy(
                timer = timeInSeconds
            )
        }

        override fun onFinish() {
            onEvent(QuizEvent.TimeRunOut)
        }
    }

    init {
        timer.start()
    }

    fun onEvent(event: QuizEvent) {
        when (event) {
            is QuizEvent.SelectOption -> {
                viewModelScope.launch {
                    timer.cancel()
                    state = state.copy(
                        isOptionSelected = true,
                        selectedAnswer = event.option
                    )
                    state = if (state.selectedAnswer == state.rightAnswer) {
                        val scoreObtained = state.timer.toInt()
                        state.copy(
                            isRightAnswer = true,
                            score = state.score.copy(score = state.score.score + scoreObtained)
                        )
                    } else {
                        state.copy(isRightAnswer = false)
                    }
                    delay(2000L)
                    if (currentIndex == 9) {
                        _navigateToSaveScore.emit(state.score.score)
                        return@launch
                    }
                    currentIndex++
                    state = state.copy(
                        currentQuestion = quiz.questions[currentIndex],
                        isOptionSelected = false,
                        timer = 30f,
                        isRightAnswer = null,
                        selectedAnswer = ""
                    )
                    timer.start()
                }
            }
            QuizEvent.TimeRunOut -> {
                viewModelScope.launch {
                    timer.cancel()
                    state = state.copy(isRightAnswer = false)
                    delay(2000L)
                    if (currentIndex == 9) {
                        _navigateToSaveScore.emit(state.score.score)
                        return@launch
                    }
                    currentIndex++
                    state = state.copy(
                        currentQuestion = quiz.questions[currentIndex],
                        isOptionSelected = false,
                        timer = 30f,
                        isRightAnswer = null,
                        selectedAnswer = ""
                    )
                    timer.start()
                }
            }
        }
    }

    fun shuffleAnswers(answers: Array<String>): List<String> {
        // first answer is the right one, so we save it before the shuffle
        state = state.copy(rightAnswer = answers[0])
        return answers.toList().shuffled()
    }
}