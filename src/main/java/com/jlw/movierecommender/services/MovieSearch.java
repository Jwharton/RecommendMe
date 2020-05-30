package com.jlw.movierecommender.services;

import com.jlw.movierecommender.restapis.model.Movie;
import com.jlw.movierecommender.restapis.model.MovieSearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
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
        int defaultPageNum = 1;
        MovieSearchResult initialResponse  = restTemplate.getForObject(String.format(
                movieAPI, apiKey, keyword, defaultPageNum), MovieSearchResult.class);

        if(initialResponse.getTotal_pages() > 1) {
            for (int i = 2; i < initialResponse.getTotal_pages(); i++) {
                initialResponse.addAdditionalPageResults(restTemplate.getForObject(String.format(
                        movieAPI, apiKey, keyword, i), MovieSearchResult.class).getResults());
            }
        }
        return initialResponse.getResults();
    }
}
