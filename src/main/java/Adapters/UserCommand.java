package Adapters;

import Application.IFetchMovieReviews;
import Application.IPrintMovieReviews;
import Application.IUserInput;
import Application.MovieApp;
import Domain.Model;
import Domain.MovieSearchRequest;

// model of commands from user
public class UserCommand implements IUserInput {
    private Model model;

    // the command accesses the core of the model and will handle the core
    public UserCommand(IFetchMovieReviews fetchMovieReviews, IPrintMovieReviews printMovieReviews) {
        MovieApp movieApp = new MovieApp(fetchMovieReviews, printMovieReviews);
        this.model = new Model(movieApp);
    }

    public void handleUserInput(Object userCommand) {  // connecting the repository to the printer, subject to a request
        this.model.Run((MovieSearchRequest)userCommand);
    }
}
