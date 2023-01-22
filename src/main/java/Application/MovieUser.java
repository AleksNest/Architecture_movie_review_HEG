package Application;

import Domain.MovieSearchRequest;

public class MovieUser {        // the user container is what we are launching
    private IUserInput userInputDriverPort;

    public MovieUser(IUserInput userInputDriverPort) {
        this.userInputDriverPort = userInputDriverPort;
    }

    public void processInput(MovieSearchRequest movieSearchRequest) {
        this.userInputDriverPort.handleUserInput(movieSearchRequest);
    }
}
