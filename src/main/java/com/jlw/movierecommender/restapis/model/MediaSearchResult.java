package com.jlw.movierecommender.restapis.model;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MediaSearchResult<T extends Media>  {

     List<T> getResults();

     void  setResults(List<T> searchByKeyword);

      List<T> getSortedDescResults();
}

