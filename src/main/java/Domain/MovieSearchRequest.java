package Domain;

//movie search query class
public class MovieSearchRequest {
    String request;

    public MovieSearchRequest(String name) {
        this.request = name;
    }

    public String getMovieName() {
        return this.request;
    }
}
