package com.jlw.movierecommender.repository;

import com.jlw.movierecommender.restapis.model.Media;
import com.jlw.movierecommender.restapis.model.Movie;

import java.util.List;

public interface SearchRepository {

    <T extends Media> List<Movie> getSearchResultsByKeyword(String keyword);
}
