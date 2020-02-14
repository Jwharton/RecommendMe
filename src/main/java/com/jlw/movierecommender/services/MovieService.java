package com.jlw.movierecommender.services;

import com.jlw.movierecommender.adapters.JSONMovieFormatter;
import com.jlw.movierecommender.model.Movie;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
@Profile("movieapi")
public class MovieService implements APIService {

    private String apiKey;

    private final RestTemplate restTemplate;

    private String getApiKey() {
        return apiKey;
    }

    private void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public MovieService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Movie> searchByKeyword(String keyword, String apiKey) {
        setApiKey(apiKey);
        String url = String.format("https://api.themoviedb.org/3/search/movie?api_key=%1s&language=en-US&query=%2s&page=1&include_adult=false", apiKey, keyword);
        return new JSONMovieFormatter().formatJSON(this.restTemplate.getForObject(url, String.class));
    }


}
