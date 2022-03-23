package com.carlosjordi.monthlychallenge03.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.QuizScreen
import com.carlosjordi.monthlychallenge03.ui.screens.save_score.ScoreScreen

@Composable
fun QuizNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Quiz.route
    ) {
        composable(route = Screen.Quiz.route) {
            QuizScreen(navController = navController)
        }
        composable(
            route = Screen.SaveScore.route + "/{score}",
            arguments = listOf(
                navArgument("score") {
                    type = NavType.IntType
                }
            )
        ) {
            ScoreScreen()
        }
    }
}