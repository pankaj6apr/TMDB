package com.pankaj6apr.tmdb.feature_movies.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.pankaj6apr.tmdb.R
import com.pankaj6apr.tmdb.Screen
import com.pankaj6apr.tmdb.common.Constants
import com.pankaj6apr.tmdb.feature_movies.domain.model.toMovieListItem
import com.pankaj6apr.tmdb.feature_movies.presentation.model.MovieListItem

@Composable
fun TrendingMoviesScreen(
    viewModel: TrendingMoviesViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.trendingMoviesState.value

    Column {
        Text(
            modifier = Modifier
                .wrapContentWidth()
                .padding(8.dp),
            text = "Trending",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            style = MaterialTheme.typography.headlineMedium,
            overflow = TextOverflow.Ellipsis
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(state.movies.movies.size) { index ->
                    TrendingMovie(
                        state.movies.movies[index].toMovieListItem()
                    ) {
                        navController.navigate(
                            Screen.MovieDetailsScreen.route
                                    + "?movieId=${state.movies.movies[index].id}"
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun TrendingMovie(movie: MovieListItem, onClick: (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .width(LocalConfiguration.current.screenWidthDp.dp/2)
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable {
                onClick?.let { it() }
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier = Modifier.height(300.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            AsyncImage(
                modifier = Modifier.height(210.dp),
                contentScale = ContentScale.Crop,
                model = "${Constants.IMAGE_URL}${movie.picturePath}",
                placeholder = painterResource(id = R.drawable.baseline_image_white_48),
                error = painterResource(id = R.drawable.baseline_image_white_48),
                contentDescription = ""
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp, top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                movie.label2?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                movie.label1?.let {
                    Text(
                        text = it,
                        maxLines = 1,
                        style = MaterialTheme.typography.bodyMedium,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(8.dp),
                text = movie.name,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}
