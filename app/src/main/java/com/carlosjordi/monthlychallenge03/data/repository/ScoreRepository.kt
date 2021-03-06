package com.carlosjordi.monthlychallenge03.data.repository

import com.carlosjordi.monthlychallenge03.data.model.Score

interface ScoreRepository {
    suspend fun addScore(score: Score)
    suspend fun getTopTenScores(): List<Score>
}