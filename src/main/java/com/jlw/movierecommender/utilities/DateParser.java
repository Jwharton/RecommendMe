package com.jlw.movierecommender.utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Locale;

public class DateParser{

    public static String parseISODateToMMDDYYYY(String isoDate){

        LocalDate localDate =  LocalDate.parse(isoDate, DateTimeFormatter.ISO_DATE);
        return localDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
    }
}
