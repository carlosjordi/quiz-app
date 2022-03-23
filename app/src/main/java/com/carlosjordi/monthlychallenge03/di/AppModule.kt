package com.carlosjordi.monthlychallenge03.di

import android.app.Application
import androidx.room.Room
import com.carlosjordi.monthlychallenge03.data.local.ScoreDao
import com.carlosjordi.monthlychallenge03.data.local.ScoreDatabase
import com.carlosjordi.monthlychallenge03.data.repository.QuizRepository
import com.carlosjordi.monthlychallenge03.data.repository.QuizRepositoryImpl
import com.carlosjordi.monthlychallenge03.data.repository.ScoreRepository
import com.carlosjordi.monthlychallenge03.data.repository.ScoreRepositoryImpl
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

    @Provides
    @Singleton
    fun provideScoreDao(scoreDatabase: ScoreDatabase): ScoreDao =
        scoreDatabase.scoreDao

    @Provides
    @Singleton
    fun provideScoreRepository(scoreDao: ScoreDao): ScoreRepository =
        ScoreRepositoryImpl(scoreDao)

    @Provides
    @Singleton
    fun provideQuizRepository(): QuizRepository = QuizRepositoryImpl()
}