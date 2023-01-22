package Application;

import Domain.MovieReview;
import Domain.MovieSearchRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

//the core of the entire program (business logic)
public class MovieApp implements Consumer <MovieSearchRequest>{
    private IFetchMovieReviews fetchMovieReviews;           // interface for request from the movie review repository of all content
    private IPrintMovieReviews printMovieReviews;           // interface (port) for printing movie reviews
    private static Random rand = new Random();

    public MovieApp(IFetchMovieReviews fetchMovieReviews, IPrintMovieReviews printMovieReviews) {
        this.fetchMovieReviews = fetchMovieReviews;
        this.printMovieReviews = printMovieReviews;
    }

    private List<MovieReview> filterRandomReviews(List<MovieReview> movieReviewList) {  // filtering business logic to be able to change the overview from the repository
        List<MovieReview> result = new ArrayList();

        for(int index = 0; index < 5 && movieReviewList.size() >= 1; ++index) {
            int randomIndex = this.getRandomElement(movieReviewList.size());
            MovieReview movieReview = (MovieReview)movieReviewList.get(randomIndex);
            movieReviewList.remove(movieReview);
            result.add(movieReview);
        }

        return result;
    }

    private int getRandomElement(int size) {
        return rand.nextInt(size);
    }

    public void accept(MovieSearchRequest movieSearchRequest) {
        List<MovieReview> movieReviewList = this.fetchMovieReviews.fetchMovieReviews(movieSearchRequest);   // request to the movie review repository
        List<MovieReview> randomReviews = this.filterRandomReviews(new ArrayList(movieReviewList));        // start filtering business logic to be able to change the overview from the repository
        this.printMovieReviews.writeMovieReviews(randomReviews);                                // output movie reviews via the interface to the console
    }
}
