package com.carlosjordi.monthlychallenge03.data.model

import androidx.annotation.ArrayRes
import androidx.annotation.StringRes

data class Question(
    @StringRes val question: Int,
    @ArrayRes val answers: Int,
)
