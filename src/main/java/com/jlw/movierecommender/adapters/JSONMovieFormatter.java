package com.jlw.movierecommender.adapters;

import com.jlw.movierecommender.model.Movie;
import com.jlw.movierecommender.utilities.DateParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONMovieFormatter implements JSONFormattable {


    @Override
    public List<Movie> formatJSON(String response) {
        List<Movie> movieList = new ArrayList<>();

        JSONObject jo = new JSONObject(response);

        JSONArray searchResults = jo.getJSONArray("results");

        for (int i = 0; i < searchResults.length(); i++) {

            JSONObject res = (JSONObject) searchResults.get(i);
            String title = (String) res.get("title");
            String overview = (String) res.get("overview");
            String releaseDate = DateParser.parseISODateToMMDDYYYY((String)res.get("release_date"));

            Movie movie = new Movie(title, overview, releaseDate);

            movieList.add(movie);
        }
        return movieList;
    }
}
