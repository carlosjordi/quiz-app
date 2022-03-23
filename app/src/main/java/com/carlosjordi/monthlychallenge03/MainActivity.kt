package com.carlosjordi.monthlychallenge03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.carlosjordi.monthlychallenge03.data.repository.QuizRepositoryImpl
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.QuizScreen
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.QuizViewModel
import com.carlosjordi.monthlychallenge03.ui.theme.MonthlyChallenge03Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val quizViewModel by viewModels<QuizViewModel> {
            QuizViewModel.QuizViewModelFactory(QuizRepositoryImpl())
        }

        setContent {
            MonthlyChallenge03Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    QuizScreen(quizViewModel)
                }
            }
        }
    }
}