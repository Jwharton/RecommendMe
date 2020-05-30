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
    @JsonProperty
    private int total_pages;
    @JsonProperty
    private int total_results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public void addAdditionalPageResults(List<Movie> additionalResults){
        results.addAll(additionalResults);
    }
}