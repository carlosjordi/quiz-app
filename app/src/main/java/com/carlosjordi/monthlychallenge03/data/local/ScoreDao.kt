package com.carlosjordi.monthlychallenge03.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.carlosjordi.monthlychallenge03.data.model.Score

@Dao
interface ScoreDao {

    @Insert
    suspend fun addScore(score: Score)

    @Query("SELECT * FROM score ORDER BY score DESC LIMIT 10")
    suspend fun getTopTenScores(): List<Score>
}