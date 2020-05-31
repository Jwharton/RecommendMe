package com.jlw.movierecommender.controllers;

import com.jlw.movierecommender.restapis.model.MediaSearchResult;
import com.jlw.movierecommender.restapis.model.Keyword;
import com.jlw.movierecommender.restapis.model.Movie;
import com.jlw.movierecommender.services.APIService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Takes in api requests from the view and sends the data to the Model object for further processing.
 * Retrieves the processed data from the Model object and pushes it to the view.
 * */
@Controller
@RequestMapping()
public class MovieSearchController {

    private APIService<Movie> apiService;
    private MediaSearchResult  mediaSearchResult;

    public MovieSearchController(APIService<Movie>  apiService, MediaSearchResult mediaSearchResult) {
        this.apiService = apiService;
        this.mediaSearchResult = mediaSearchResult;
    }

   /**
     *
     * @param keywordObj
     * @param model
     * @return
     */
    @GetMapping({"/movieSearch"})
    public String movieTitleKeywordSearch(@ModelAttribute Keyword keywordObj, Model model) {

            mediaSearchResult.setResults(apiService.searchByKeyword(keywordObj.getKeyword()));
            model.addAttribute("movies", mediaSearchResult.getSortedDescResults());

        return "movieSearch";
    }

}
