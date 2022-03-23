package com.carlosjordi.monthlychallenge03.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.carlosjordi.monthlychallenge03.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Column {
        Button(onClick = { navController.navigate(Screen.Quiz.route) }) {
            Text(text = "Play")
        }
        Button(onClick = { navController.navigate(Screen.Ranking.route) }) {
            Text(text = "Rankings")
        }
    }
}