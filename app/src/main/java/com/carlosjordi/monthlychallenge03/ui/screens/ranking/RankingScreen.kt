package com.carlosjordi.monthlychallenge03.ui.screens.ranking

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RankingScreen(
    rankingViewModel: RankingViewModel = hiltViewModel()
) {
    val state = rankingViewModel.state
    val lazyState = rememberLazyListState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Top Rankings")
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            state = lazyState
        ) {
            items(items = state.topRankings) { ranking ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = ranking.username)
                    Text(text = ranking.score.toString())
                }
            }
        }
    }

}