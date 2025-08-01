package com.example.newsapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsapp.domain.manager.LocalUserManager
import com.example.newsapp.util.Constants.APP_ENTRYS
import com.example.newsapp.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserImplementation(

    private  val context: Context

): LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit{ setting->
            setting[PreferencesKeys.APP_ENTRY]
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map{preferences->
            preferences[PreferencesKeys.APP_ENTRY]?:false
        }
    }

}
private  val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name= USER_SETTINGS)
private object PreferencesKeys{
    val APP_ENTRY= booleanPreferencesKey(name=APP_ENTRYS)
}