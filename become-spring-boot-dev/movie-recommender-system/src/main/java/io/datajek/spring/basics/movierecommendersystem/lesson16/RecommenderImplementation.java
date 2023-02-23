package io.datajek.spring.basics.movierecommendersystem.lesson16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommenderImplementation {

    @Autowired
    private Filter filter;

    public String[] recommendMovies(String movie) {

        System.out.println("Name of the filter in use: " + filter.getClass().getSimpleName() + "\n");

        String[] results = filter.getRecommendations(movie);

        return results;
    }

}
