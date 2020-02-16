package com.jlw.movierecommender.controllers;

import com.jlw.movierecommender.services.APIService;
import com.jlw.movierecommender.utilities.PropertyFileReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"", "/","home","index","welcome"})
public class APIController {

    private final static String PROPERTY_FILE_PATH = "./passwords.properties";
    private final static String PROPERTY_API_KEY_KEY = "apiKey";

    private APIService apiService;
    private String apiKey = new PropertyFileReader(PROPERTY_FILE_PATH).getPropertyValue(PROPERTY_API_KEY_KEY);

    public APIController(APIService apiService) {
        this.apiService = apiService;
    }

    @GetMapping
        public String displaySearchResults(Model model) {

            model.addAttribute("movies", apiService.searchByKeyword("rush", apiKey));
            return "movie_search"; //view
        }
}
