package com.example.newsapp.presentation

import androidx.annotation.DrawableRes
import com.example.newsapp.R

data class Page(
    val title:String,
    val description:String,
    @DrawableRes val image:Int
)

val pages=listOf(
    Page(
        title = "AAA",
        description = "BBB",
        image = R.drawable.news
    ),
    Page(
        title = "AAA",
        description = "BBB",
        image = R.drawable.news
    ),
    Page(
        title = "AAA",
        description = "BBB",
        image = R.drawable.news
    )
)