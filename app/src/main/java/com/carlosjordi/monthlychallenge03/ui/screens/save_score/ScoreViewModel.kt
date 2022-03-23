package com.carlosjordi.monthlychallenge03.ui.screens.save_score

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosjordi.monthlychallenge03.data.repository.ScoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreViewModel @Inject constructor(
    private val scoreRepository: ScoreRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(ScoreState())
        private set

    init {
        savedStateHandle.get<Int>("score")?.let { finalScore ->
            state = state.copy(
                score = state.score.copy(
                    score = finalScore
                )
            )
        }
    }

    fun onEvent(scoreEvent: ScoreEvent) {
        when (scoreEvent) {
            ScoreEvent.SaveScore -> {
                // we need an username to save the score
                if (state.score.username == "") return
                viewModelScope.launch {
                    scoreRepository.addScore(state.score)
                }
            }
            is ScoreEvent.OnUsernameEntered -> {
                state = state.copy(
                    score = state.score.copy(
                        username = scoreEvent.username
                    )
                )
            }
        }
    }
}