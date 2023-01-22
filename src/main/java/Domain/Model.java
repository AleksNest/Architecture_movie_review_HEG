package Domain;

import Application.MovieApp;

// core model (structure)
public class Model {
    private MovieApp movieApp;              // instance of the movieApp kernel class
    public Model(MovieApp movieApp) {
        this.movieApp = movieApp;
    }

    public void Run(MovieSearchRequest movieSearchRequest) {
        this.movieApp.accept(movieSearchRequest);               // launching the business logic of the application
    }
}
