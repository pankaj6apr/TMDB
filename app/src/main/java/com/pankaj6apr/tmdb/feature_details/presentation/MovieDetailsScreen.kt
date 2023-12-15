package com.pankaj6apr.tmdb.feature_details.presentation

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.pankaj6apr.tmdb.R
import com.pankaj6apr.tmdb.common.Constants
import com.pankaj6apr.tmdb.feature_trending.domain.model.toMovieListItem
import com.pankaj6apr.tmdb.feature_trending.presentation.TrendingMovie

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel = hiltViewModel(),
    navController: NavController,
    id: String
) {
    val state = viewModel.movieDetailsState.value
    viewModel.saveMovieid(id)

    state.movieDetails?.let {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                model = "${Constants.IMAGE_URL}${it.posterPath}",
                placeholder = painterResource(id = R.drawable.baseline_image_white_48),
                error = painterResource(id = R.drawable.baseline_image_white_48),
                contentDescription = ""
            )

            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(8.dp),
                text = it.name,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                style = MaterialTheme.typography.headlineMedium,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = it.votePercentage.toString() + "%",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "User Score",
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(8.dp),
                text = it.genres,
                maxLines = 1,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = "Overview",
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                style = MaterialTheme.typography.headlineSmall,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = it.overview,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = "Seasons",
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                style = MaterialTheme.typography.headlineSmall,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .horizontalScroll(rememberScrollState())
            ) {
                it.seasons.map { season ->
                    TrendingMovie(season, navController, false)
                }
            }
        }
    }
}