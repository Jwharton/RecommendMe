package com.jlw.movierecommender.controllers;

import com.jlw.movierecommender.restapis.model.Keyword;
import com.jlw.movierecommender.restapis.model.MediaSearchResult;
import com.jlw.movierecommender.restapis.model.Movie;
import com.jlw.movierecommender.services.APIService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Takes in api requests from the view and sends the data to the Model object for further processing.
 * Retrieves the processed data from the Model object and pushes it to the view.
 * */
@Controller
@RequestMapping()
public class IndexController {

    @GetMapping({"/", "/index", "/home"})
    public String index(@ModelAttribute Keyword keywordObj, Model model) {

        model.addAttribute("search", keywordObj);

        return "index";
    }
}
