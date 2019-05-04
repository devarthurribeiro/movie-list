package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Movie;

@ManagedBean(name = "movieCtrl")
public class MovieController {

    private Movie movie = new Movie();
    private List<Movie> movies = new ArrayList<>();

    public MovieController() {
    }

    public void add() {
        movie.save();
        movies = Movie.all();
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
