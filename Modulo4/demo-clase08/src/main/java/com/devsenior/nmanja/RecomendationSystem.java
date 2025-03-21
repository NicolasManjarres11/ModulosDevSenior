package com.devsenior.nmanja;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class RecomendationSystem {

    private List<Movie> movies;

    public void loadMovies(Collection<Movie> movies){
        
        this.movies = new ArrayList<>(movies);

    }

    public List<String> getGenres(){

        return movies.stream()
            .map(Movie::getGenre) //Coge cada genero de cada pelicula
            .distinct() //Se quitan repetidos
            .sorted() //Se ordenda de forma alfabetica
            .toList(); //Se devuelve una lista

    }

    public List<Movie> getMoviesByGenre(String genre){

        return movies.stream()
            .filter(m -> m.getGenre().equals(genre))
            .toList();
    }

    public List<Movie> getRecommendationByGenre(String genre) {
        return movies.stream()
            .filter(m -> m.getGenre().equals(genre))
            .filter(this::claisificate)
            .sorted(Comparator.comparingDouble(Movie::getRating).reversed()
                .thenComparing(Movie::getTitle))
            .toList();
    }

    private boolean claisificate(Movie m){
        return m.getRating() > 4.0 && m.getVotes() >= 100;
    }

}
