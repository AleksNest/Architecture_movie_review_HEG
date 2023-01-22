package Application;

import Domain.MovieReview;
import java.util.List;

// interface (port) for printing movie reviews
public interface IPrintMovieReviews {
    void writeMovieReviews(List<MovieReview> movieReviewList);
}
