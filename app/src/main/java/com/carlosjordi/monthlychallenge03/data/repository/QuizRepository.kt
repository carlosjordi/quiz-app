package com.carlosjordi.monthlychallenge03.data.repository

import com.carlosjordi.monthlychallenge03.data.model.Quiz

interface QuizRepository {

    fun getQuiz(): Quiz
}