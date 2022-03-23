package com.carlosjordi.monthlychallenge03.ui.screens.ranking

import com.carlosjordi.monthlychallenge03.data.model.Score

data class RankingState(
    val topRankings: List<Score> = emptyList()
)
