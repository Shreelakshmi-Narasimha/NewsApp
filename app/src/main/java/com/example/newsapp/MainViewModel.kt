package com.example.newsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.usecases.app_entry.AppEntryUsecases
import com.example.newsapp.presentation.onboarding.nvgraph.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUsecases: AppEntryUsecases
) : ViewModel(){

  var splashCondition by mutableStateOf(true)
    private set

var startDestination by mutableStateOf(Routes.AppStartNavigation.routes)
    private set

    init {
        appEntryUsecases.readAppEntry().onEach { shouldStartformHomeScreen->
            if(shouldStartformHomeScreen){
                startDestination=Routes.NewsNavigation.routes
            }else{
                startDestination=Routes.AppStartNavigation.routes
            }
            delay(300)
            splashCondition=false
        }.launchIn(viewModelScope)
    }
}