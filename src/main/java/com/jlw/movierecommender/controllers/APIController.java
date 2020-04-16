package com.jlw.movierecommender.controllers;

import com.jlw.movierecommender.restapis.model.MediaSearchResult;
import com.jlw.movierecommender.restapis.model.Search;
import com.jlw.movierecommender.services.APIService;
import com.jlw.movierecommender.utilities.PropertyFileReader;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
public class APIController {

    private  APIService apiService;
    private  MediaSearchResult mediaSearchResult;

    public APIController(APIService apiService, MediaSearchResult mediaSearchResult) {
        this.apiService = apiService;
        this.mediaSearchResult = mediaSearchResult;
    }


    @GetMapping(value="")
    public String searchResult(Model model){
        model.addAttribute("search", new Search());
        model.addAttribute("movies", mediaSearchResult.getResults());
        return "index";
    }

    @PostMapping(value ="")
    public String displaySearchResults(Search searchObj) {

        mediaSearchResult.setResults(apiService.searchByKeyword(searchObj.getKeyword()));
        return "redirect:/";
    }

}
