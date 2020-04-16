package com.jlw.movierecommender.services;

import com.jlw.movierecommender.restapis.model.Media;
import com.jlw.movierecommender.restapis.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface APIService<T> {

    <T extends Media> List<T> searchByKeyword(String keyWord);

}
