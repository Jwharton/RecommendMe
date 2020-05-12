package com.jlw.movierecommender.controllers;

import com.jlw.movierecommender.restapis.model.Media;
import com.jlw.movierecommender.restapis.model.MediaSearchResult;
import com.jlw.movierecommender.restapis.model.Search;
import com.jlw.movierecommender.services.APIService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/index"})
public class APIController {

    private APIService<Media> apiService;
    private MediaSearchResult  mediaSearchResult;

    public APIController(APIService<Media>  apiService, MediaSearchResult mediaSearchResult) {
        this.apiService = apiService;
        this.mediaSearchResult = mediaSearchResult;
    }

    @GetMapping({"/", "/index", "{pageRequested}"})
    public String main(@PathVariable(required = false) String pageRequested, Search searchObj, Model model) {
        if (null == searchObj.getKeyword()) {
            model.addAttribute("search", new Search());
        } else {
            mediaSearchResult.setResults(apiService.searchByKeyword(searchObj.getKeyword()));
            model.addAttribute("movies", mediaSearchResult.getResults());
            return pageRequested;
        }
        return "index";
    }
}
