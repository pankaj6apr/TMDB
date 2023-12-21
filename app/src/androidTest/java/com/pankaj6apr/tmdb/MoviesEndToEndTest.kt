package com.pankaj6apr.tmdb

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.unit.IntSize
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pankaj6apr.tmdb.common.TestTags
import com.pankaj6apr.tmdb.feature_movie_details.presentation.MovieDetailsScreen
import com.pankaj6apr.tmdb.feature_movies.presentation.components.movieList.TrendingMoviesScreen
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MoviesEndToEndTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get: Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()

        composeRule.activity.setContent {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.TrendingMoviesScreen.route
                    ) {
                        composable(route = Screen.TrendingMoviesScreen.route) {
                            TrendingMoviesScreen(
                                navController = navController
                            )
                        }

                        composable(
                            route = Screen.MovieDetailsScreen.route + "?movieId={movieId}",
                            arguments = listOf(
                                navArgument(
                                    name = "movieId"
                                ) {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            MovieDetailsScreen(
                                navController = navController
                            )
                        }
                    }
                }
        }
    }

    @Test
    fun showTrendingMoviesOnLoad() = runTest {
        // check movie is visible
        composeRule.onAllNodesWithTag(TestTags.TrendingListItemCard).onFirst().assertIsDisplayed()
        composeRule.onNodeWithText("Doctor Who").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun showSearchedMovies() = runTest {
        // enter search text
        composeRule.onNodeWithTag(TestTags.SearchBoxInput)
            .performTextInput("Big Bang")

        composeRule.waitUntilDoesNotExist(
            hasText("Doctor Who")
        )

        // check card is visible
        composeRule.onNodeWithText("Big Bang Theory").assertIsDisplayed()
    }

    @Test
    fun showDetailedMovie_OnCardClick() = runTest {
        // check movie is visible
        composeRule.onNodeWithText("Doctor Who").assertIsDisplayed()

        // perform click on the card
        composeRule.onAllNodesWithTag(TestTags.TrendingListItemCard).onFirst().performClick()

        // check movie details show up
        composeRule.onNodeWithTag(TestTags.MovieDetailsTitle).assertIsDisplayed()
        composeRule.onNodeWithText("Doctor Who").assertIsDisplayed()
    }
}