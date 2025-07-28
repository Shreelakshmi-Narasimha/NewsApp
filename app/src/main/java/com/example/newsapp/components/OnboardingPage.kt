package com.example.newsapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.R
import com.example.newsapp.presentation.Dimens.mediumPadding1
import com.example.newsapp.presentation.Dimens.mediumPadding2
import com.example.newsapp.presentation.Page
import com.example.newsapp.presentation.pages
import com.example.newsapp.ui.theme.NewsAppTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier= Modifier,
    page: Page
){
    Column(modifier) {
        Image(modifier= Modifier.
        fillMaxWidth()
            .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id=page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier= Modifier.heightIn(mediumPadding1))

        Text(text = page.title,
            modifier= Modifier.padding(horizontal = mediumPadding1), style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id= R.color.display_small)
        )

        Text(text = page.description,
            modifier= Modifier.padding(horizontal = mediumPadding2), style = MaterialTheme.typography.displayMedium,
            color = colorResource(id= R.color.text_medium)
        )

    }
}
@Preview
@Composable
fun onBoardingPreview(){
    NewsAppTheme {
        OnBoardingPage(page=
            pages[0]
        )
    }
}
