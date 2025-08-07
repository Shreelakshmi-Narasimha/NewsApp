package com.example.newsapp.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.Dimens.mediumPadding1

fun ArtclesList(
    modifier: Modifier= Modifier,
    article: LazyPagingItems<Article>,
    onClick:(Article)->Unit
) {


}

@Composable
fun handlePagingResult(
    article: LazyPagingItems<Article>
): Boolean{
    val loadState=article.loadState
    val error=when{
        loadState.refresh is LoadState.Error->loadState.refresh as LoadState.Error
        loadState.refresh is LoadState.Error->loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error->loadState.append as LoadState.Error
        else->null
    }
    return when{
        loadState.refresh is LoadState.Loading->{
            ShimmerEffect()
        false
        }
        error !=null->{

            false
        }
    }
}
@Composable
private fun ShimmerEffect(){
    Column(verticalArrangement = Arrangement.spacedBy(mediumPadding1)) {
        repeat(10){
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = mediumPadding1)
            )
        }
    }
}