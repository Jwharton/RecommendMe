package com.jlw.movierecommender.services;

import com.jlw.movierecommender.restapis.model.Media;
import com.jlw.movierecommender.restapis.model.Movie;

import java.util.List;

public interface Search {

    <T extends Media> List<Movie> getSearchResultsByKeyword(String keyword);
}
