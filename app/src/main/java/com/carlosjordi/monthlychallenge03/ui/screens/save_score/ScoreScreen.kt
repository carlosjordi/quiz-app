package com.carlosjordi.monthlychallenge03.ui.screens.save_score

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.carlosjordi.monthlychallenge03.navigation.Screen

@Composable
fun ScoreScreen(
    scoreViewModel: ScoreViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val state = scoreViewModel.state

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = state.score.username,
            onValueChange = { scoreViewModel.onEvent(ScoreEvent.OnUsernameEntered(it)) }
        )
        if (!state.saved) {
            Button(onClick = { scoreViewModel.onEvent(ScoreEvent.SaveScore) }) {
                Text(text = "Save Score")
            }
        } else {
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Play Again")
                }
                Button(onClick = { navController.navigate(Screen.Ranking.route) }) {
                    Text(text = "Rankings")
                }
            }
        }
    }
}