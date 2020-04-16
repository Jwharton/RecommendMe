package com.jlw.movierecommender.repository;

import com.jlw.movierecommender.restapis.model.Movie;
import com.jlw.movierecommender.restapis.model.MovieSearchResult;
import com.jlw.movierecommender.utilities.PropertyFileReader;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class MovieSearchRepository implements SearchRepository {

    private final static String PROPERTY_FILE_PATH = "./passwords.properties";
    private final static String PROPERTY_API_KEY_KEY = "apiKey";

    @Override
    public List<Movie> getSearchResultsByKeyword(String keyword) {

        String apiKey = new PropertyFileReader(PROPERTY_FILE_PATH).getPropertyValue(PROPERTY_API_KEY_KEY);

        RestTemplate restTemplate = new RestTemplate();
        MovieSearchResult response  = restTemplate.getForObject(String.format(
                "https://api.themoviedb.org/3/search/movie?api_key=%s&language=en-US&query=%s&page=1&include_adult=false", apiKey, keyword), MovieSearchResult.class);

        return response.getResults();
    }
}
