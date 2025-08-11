package com.example.newsapp.presentation.common

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newsapp.R
import com.example.newsapp.presentation.Dimens.IconSize

@Composable
fun Searchbar(
    modifier: Modifier= Modifier,
    text:String,
    readOnly: Boolean,
    onClick:(()->Unit)?=null,
    onValueChange:(String)->Unit,
    onSearch:()->Unit
){
    val interactionSouce= remember{
        MutableInteractionSource()
    }
    val isClicked =interactionSouce.collectIsPressedAsState().value
    LaunchedEffect(key1=isClicked) {
        if(isClicked){
            onClick?.invoke()
        }
    }
    Box(modifier=modifier){
        TextField(            modifier= Modifier.fillMaxWidth(),
        value=text,onValueChange=onValueChange,
            readOnly=readOnly,
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_search),contentDescription = null,
                    modifier = Modifier.size(IconSize),
                    tint = colorResource(id = R.color.body)
                )
            },
            placeholder = {

            },
        )
    }



}

fun Modifier.seachBarBorder()=composed {
    if(!isSystemInDarkTheme()){
        border(
            width=1.dp,
            color = Color.Black,
            shape = MaterialTheme.shapes.medium
        )
    }else{
        this
    }
}