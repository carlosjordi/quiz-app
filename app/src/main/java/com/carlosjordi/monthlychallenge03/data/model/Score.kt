package com.carlosjordi.monthlychallenge03.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Score(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val score: Int = 0,
    val username: String = ""
)
