package com.carlosjordi.monthlychallenge03.di

import android.app.Application
import androidx.room.Room
import com.carlosjordi.monthlychallenge03.data.local.ScoreDatabase
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.components.Score
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideScoreDatabase(
        application: Application
    ): ScoreDatabase = Room.databaseBuilder(
        application,
        ScoreDatabase::class.java,
        ScoreDatabase.DATABASE_NAME
    ).build()
}