package com.carlosjordi.monthlychallenge03.navigation

sealed class Screen(val route: String) {
    object Quiz : Screen("quiz_route")
    object SaveScore : Screen("save_score_route")
    object Ranking : Screen("ranking_route")
}