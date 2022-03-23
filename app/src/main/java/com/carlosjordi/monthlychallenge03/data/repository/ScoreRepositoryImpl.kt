package com.carlosjordi.monthlychallenge03.data.repository

import com.carlosjordi.monthlychallenge03.data.local.ScoreDao
import com.carlosjordi.monthlychallenge03.data.model.Score

class ScoreRepositoryImpl(
    private val scoreDao: ScoreDao
) : ScoreRepository {
    override suspend fun addScore(score: Score) {
        scoreDao.addScore(score)
    }

    override fun getTopTenScores(): List<Score> {
        return scoreDao.getTopTenScores()
    }
}