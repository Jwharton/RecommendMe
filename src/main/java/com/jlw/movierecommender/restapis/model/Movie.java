package com.jlw.movierecommender.restapis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie extends Media implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @JsonProperty
    private String title;
    @JsonProperty
    private LocalDate release_date;
    @JsonProperty
    private String overview;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return null == release_date ? "" : release_date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
    }

    public LocalDate getReleaseLocalDate() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }


}
