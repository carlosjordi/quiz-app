package com.carlosjordi.monthlychallenge03.ui.screens.save_score

sealed class ScoreEvent {
    object SaveScore : ScoreEvent()
    data class OnUsernameEntered(val username: String) : ScoreEvent()
}
