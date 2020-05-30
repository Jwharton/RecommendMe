package com.jlw.movierecommender.repository;

import com.jlw.movierecommender.restapis.model.Movie;
import com.jlw.movierecommender.restapis.model.MovieSearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@PropertySources({
        @PropertySource("passwords.properties"),
        @PropertySource("api_config.properties")
})
public class MovieSearch implements Search{

    @Value("${apiKey}")
    private String apiKey;

    @Value("${movie.title.search.endpoint}")
    private String movieAPI;



    @Override
    public List<Movie> getSearchResultsByKeyword(String keyword) {
        RestTemplate restTemplate = new RestTemplate();
        MovieSearchResult response  = restTemplate.getForObject(String.format(
                movieAPI, apiKey, keyword), MovieSearchResult.class);

        return response.getResults();
    }
}
