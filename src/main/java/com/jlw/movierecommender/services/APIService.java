package com.jlw.movierecommender.services;

import com.jlw.movierecommender.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface APIService {

    List<Movie> searchByKeyword(String name, String apiKey);

}
