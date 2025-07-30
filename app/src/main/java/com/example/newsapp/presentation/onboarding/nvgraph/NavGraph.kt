package com.example.newsapp.presentation.onboarding.nvgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.newsapp.presentation.onboarding.OnBoardingScreen
import com.example.newsapp.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination:String
){
    val navController= rememberNavController()

    NavHost(navController=navController,startDestination=startDestination){
        navigation(
            route= Routes.AppStartNavigation.routes,
            startDestination= Routes.OnBoardingScreen.routes
        ){
            composable(
                route= Routes.OnBoardingScreen.routes
            ){
                val viewModel: OnBoardingViewModel= hiltViewModel()
                OnBoardingScreen(event = {
                    viewModel::onEvent
                })
            }
        }
        navigation(route= Routes.NewsNavigation.routes,
            startDestination= Routes.NewsNavigatorScreen.routes){
            composable(route= Routes.NewsNavigatorScreen.routes){
                Text(text ="News Naviagtor screen" )
            }
        }
    }
}