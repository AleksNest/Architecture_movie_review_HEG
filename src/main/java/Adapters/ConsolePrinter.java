
package Adapters;

import Application.IPrintMovieReviews;
import Domain.MovieReview;
import java.util.List;

// output to the console movie reviews
public class ConsolePrinter implements IPrintMovieReviews {
    public ConsolePrinter() {
    }
@Override
    public void writeMovieReviews(List<MovieReview> movieReviewList) {  // output to the console of all movie reviews
        movieReviewList.forEach((movieReview) -> {
            System.out.println(movieReview.toString());
        });
    }
}
