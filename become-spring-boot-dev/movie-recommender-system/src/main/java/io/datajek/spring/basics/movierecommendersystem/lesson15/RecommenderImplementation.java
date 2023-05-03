package io.datajek.spring.basics.movierecommendersystem.lesson15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    @Autowired
    @Qualifier("CBF")
    private Filter contentBasedFilter;

    @Value("${recommender.implementation.favoriteMovie:Losing Dory}")
    private String favoriteMovie;

    public String[] recommendMovies(String movie) {

        System.out.println("Name of the filter in use: " + contentBasedFilter.getClass().getSimpleName() + "\n");

        String[] results = contentBasedFilter.getRecommendations("Finding Dorry");

        return results;
    }

    public String getFavouriteMovie() {
        return favoriteMovie;
    }
}
