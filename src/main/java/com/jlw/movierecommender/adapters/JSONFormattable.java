package com.jlw.movierecommender.adapters;

import com.jlw.movierecommender.model.Media;

import java.util.List;

public interface JSONFormattable {

    List<? extends Media> formatJSON(String response);
}
