package Adapters;

import Application.IFetchMovieReviews;
import Domain.MovieReview;
import Domain.MovieSearchRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Movie Reviews Repository
public class MovieReviewsRepo implements IFetchMovieReviews {
    private Map<String, List<MovieReview>> movieReviewMap;      // repository of movie reviews

    public MovieReviewsRepo() {
        this.initialize();
    }       // initialization repository

    public List<MovieReview> fetchMovieReviews(MovieSearchRequest movieSearchRequest) { // fetching Movie Reviews for interface IPrintMovieReviews
        return (List)Optional.ofNullable((List)this.movieReviewMap.get(movieSearchRequest.getMovieName())).orElse(new ArrayList());
    }

    private void initialize() {     // adding to the list of movie reviews to repository
        this.movieReviewMap = new HashMap();
        this.movieReviewMap.put("StarWars", Collections.singletonList(new MovieReview("1", 7.5, "Good")));
        this.movieReviewMap.put("StarTreck", Arrays.asList(new MovieReview("1", 9.5, "Excellent"), new MovieReview("1", 8.5, "Good")));
    }
}
