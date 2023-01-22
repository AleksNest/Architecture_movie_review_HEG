package Application;

import Domain.MovieReview;
import Domain.MovieSearchRequest;
import java.util.List;

public interface IFetchMovieReviews {   // port for request from the movie review repository of all content
   public List<MovieReview> fetchMovieReviews(MovieSearchRequest movieSearchRequest); // output of all content from the repository
}
