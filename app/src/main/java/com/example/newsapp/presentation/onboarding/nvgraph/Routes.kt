package com.example.newsapp.presentation.onboarding.nvgraph

sealed class Routes(
    val routes:String
){
    object OnBoardingScreen: Routes(routes = "OnBoardingScreen")
    object HomeScreen: Routes(routes = "homeScreen")
    object SearchScreen: Routes(routes = "searchScreen")
    object BookmarkScreen: Routes(routes = "bookmarkScreen")
    object DetailScreen: Routes(routes = "detailsScreen")
    object NewsNavigatorScreen: Routes(routes = "newsNavigatorScreen")
    object AppStartNavigation: Routes(routes = "appStartNavigation")
    object NewsNavigation: Routes(routes = "newsNavigation")
}