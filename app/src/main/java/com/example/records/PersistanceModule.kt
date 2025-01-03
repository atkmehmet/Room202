package com.example.records

import android.content.Context
import androidx.room.Dao
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PersistanceModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context):AppDataBase= Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "myRecords"
    ).build()

    @Provides
    @Singleton
    fun providesDao(dataBase: AppDataBase) :AppDao = dataBase.appDao()


}
