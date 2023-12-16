# Android app for TV series using TMDB APIs
Using TMDB APIs to create an Android app to show TV series. The app uses MVVM design pattern with clean architecture best practices and the following libraries
- Retrofit to make API calls.
- Room database to store likes.
- Jetpack compose for UI
- Dagger/Hilt for dependency injection.
### Features
- Shows a list of trending TV series for this week
- Ability to search for the TV series you are looking for.
- Shows details of a TV series when you tap on it. Also, shows a list of seasons for the series and TV series that are similar to it.
- Ability to like a TV series but it only persists locally.
### APIs
- List of trending TV series of the week - https://api.themoviedb.org/3/trending/tv/week
- Details about a particular TV series - https://api.themoviedb.org/3/tv/{id}
- List of similar TV series to a given TV series - https://api.themoviedb.org/3/tv/{id}/similar
- Search for a TV series - https://api.themoviedb.org/3/search/tv?query={query}

## Trending TV series, details of a TV series and similar TV series to it
![](https://github.com/pankaj6apr/TMDB/blob/master/Home.gif)
## Search
![](https://github.com/pankaj6apr/TMDB/blob/master/search.gif)
## Like
![](https://github.com/pankaj6apr/TMDB/blob/master/Like.gif)
## Error Handling
![](https://github.com/pankaj6apr/TMDB/blob/master/error.gif)
## Loading indicator
![](https://github.com/pankaj6apr/TMDB/blob/master/loading.gif)
