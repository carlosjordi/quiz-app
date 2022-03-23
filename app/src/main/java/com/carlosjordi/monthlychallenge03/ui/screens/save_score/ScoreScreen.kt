package com.carlosjordi.monthlychallenge03.ui.screens.save_score

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ScoreScreen(
    scoreViewModel: ScoreViewModel = hiltViewModel()
) {
    val state = scoreViewModel.state

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = state.score.username,
            onValueChange = { scoreViewModel.onEvent(ScoreEvent.OnUsernameEntered(it)) }
        )
        Button(onClick = { scoreViewModel.onEvent(ScoreEvent.SaveScore) }) {
            Text(text = "Save Score")
        }
    }
}