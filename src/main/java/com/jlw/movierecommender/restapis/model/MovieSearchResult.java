package com.jlw.movierecommender.restapis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieSearchResult implements Serializable, MediaSearchResult<Movie> {
    @JsonProperty
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

}