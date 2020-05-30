package com.jlw.movierecommender.services;

import com.jlw.movierecommender.repository.MovieSearch;
import com.jlw.movierecommender.restapis.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("movieapi")
public class MovieSearchService implements APIService {


    private MovieSearch movieSearch;

    @Autowired
    public MovieSearchService(MovieSearch movieSearch) {
        this.movieSearch = movieSearch;
    }

    @Override
    public List<Movie> searchByKeyword(String keyWord) {
        return movieSearch.getSearchResultsByKeyword(keyWord);
    }
}
