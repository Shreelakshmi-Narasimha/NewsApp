package com.example.newsapp.presentation.onboarding.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.newsapp.presentation.Dimens.IndicatorSize
import com.example.newsapp.ui.theme.BlueGray

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize:Int,
    selectedPage:Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor:Color=BlueGray
){
    Row(modifier = modifier, horizontalArrangement = Arrangement.Absolute.SpaceBetween){
        repeat(pageSize){
            page->
            Box(modifier= Modifier.size(IndicatorSize).clip(CircleShape)
                .background(color = if(page==selectedPage) selectedColor else unselectedColor))
        }
    }
}