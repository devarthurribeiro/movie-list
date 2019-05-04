package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Movie;

@ManagedBean(name="cartCtrl")
@SessionScoped
public class CartController {
    private List<Movie> movies = new ArrayList<>();
    
    public void add(Movie movie) {
        if (movie.getEstoque() > 0) {
            movie.setEstoque(movie.getEstoque()- 1);
            movie.save();
            movies.add(movie);
        }
    }
    
    public void remove(Movie movie) {
        
    }

    public List<Movie> getMovies() {
        return movies;
    }
    
}
