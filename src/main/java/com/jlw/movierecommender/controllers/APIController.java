package com.jlw.movierecommender.controllers;

import com.jlw.movierecommender.services.APIService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class APIController {

    APIService apiService;

    public APIController(APIService apiService) {
        this.apiService = apiService;
    }

    @GetMapping
        public String displaySearchResults(Model model) {

            //model.addAttribute("movies", apiService.searchByKeyword("Super", "TVMDB API Key"));
            return "movie_search"; //view
        }
}
