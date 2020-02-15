package com.jlw.movierecommender.utilities;

import com.jlw.movierecommender.MovieRecommenderApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyFileReader implements PropertyReader {

    private Properties properties;

    public PropertyFileReader(String path) {
        this.properties = readPropertyFile(path);
    }

    @Override
    public Properties readPropertyFile(String path) {

        Properties prop = new Properties();

        try (InputStream input = MovieRecommenderApplication.class.getClassLoader().getResourceAsStream(path)) {

            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public String getPropertyValue(String key){
        return properties.getProperty(key);
    }
}
