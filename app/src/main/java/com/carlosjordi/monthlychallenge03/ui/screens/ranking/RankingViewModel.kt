package com.carlosjordi.monthlychallenge03.ui.screens.ranking

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosjordi.monthlychallenge03.data.repository.ScoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val scoreRepository: ScoreRepository
) : ViewModel() {

    var state by mutableStateOf(RankingState())
        private set

    init {
        viewModelScope.launch {
            val topTenScores = scoreRepository.getTopTenScores()
            state = state.copy(topRankings = topTenScores)
        }
    }
}