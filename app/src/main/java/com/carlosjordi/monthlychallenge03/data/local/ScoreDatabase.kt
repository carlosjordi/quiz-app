package com.carlosjordi.monthlychallenge03.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.carlosjordi.monthlychallenge03.data.model.Score

@Database(
    entities = [Score::class],
    version = 1
)
abstract class ScoreDatabase : RoomDatabase() {
    abstract val scoreDao: ScoreDao

    companion object {
        const val DATABASE_NAME = "score_db.mc"
    }
}