package com.tvr.androidtemplate.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.data.local.RoomDb
import com.tvr.androidtemplate.data.local.SharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    /**
     * providing shared SharedPreferences instance here
     */
    @Provides
    @Singleton
    internal fun getSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            context.getString(R.string.package_name),
            Context.MODE_PRIVATE
        )
    }

    /**
     * get shared pref instance here
     */
    @Provides
    @Singleton
    internal fun getSharedPref(sharedPreferences: SharedPreferences): SharedPref{
        return SharedPref(sharedPreferences)
    }

    /**
     * getting room db instance here
     */
    @Provides
    @Singleton
    internal fun getRoomDb(@ApplicationContext context: Context): RoomDatabase{
        return Room.databaseBuilder(
            context, RoomDb::class.java,
            context.getString(R.string.db_name)
        ).build();
    }
}