package com.jlw.movierecommender.services;

import com.jlw.movierecommender.repository.MovieSearchRepository;
import com.jlw.movierecommender.restapis.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("movieapi")
public class MovieService implements APIService {


    private MovieSearchRepository repo;

    @Autowired
    public MovieService(MovieSearchRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Movie> searchByKeyword(String keyWord) {
        return repo.getSearchResultsByKeyword(keyWord);
    }
}
