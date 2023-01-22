
import Adapters.ConsolePrinter;
import Adapters.MovieReviewsRepo;
import Adapters.UserCommand;
import Application.IFetchMovieReviews;
import Application.IPrintMovieReviews;
import Application.IUserInput;
import Application.MovieUser;
import Domain.MovieSearchRequest;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        IFetchMovieReviews fetchMovieReviews =  new MovieReviewsRepo(); //  creating a repository adapter object (IFetchMovieReviews)
        IPrintMovieReviews printMovieReviews =  new ConsolePrinter(); //    creating a printer adapter object   (IPrintMovieReviews)
        IUserInput userCommand = new UserCommand(fetchMovieReviews, printMovieReviews); // creating a command object from a user

        MovieUser movieUser = new MovieUser(userCommand);       // пользователь, куда вкладывается контейнер
        MovieSearchRequest starWarsRequest = new MovieSearchRequest("StarWars");    // creating a movie search object
        MovieSearchRequest starTreckRequest = new MovieSearchRequest("StarTreck");  // creating a movie search object

        System.out.println("Displaying reviews for movie " + starTreckRequest.getMovieName());
        movieUser.processInput(starTreckRequest);           // running logic to connect ports
        System.out.println("Displaying reviews for movie " + starWarsRequest.getMovieName());
        movieUser.processInput(starWarsRequest);            // running logic to connect ports
    }
}
