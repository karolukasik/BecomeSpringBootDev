package io.datajek.spring.basics.movierecommendersystem.lesson7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation2 {

    private Filter filter;

    public String[] recommendMovies(String movie) {

        System.out.println("Name of the filter in use: " + filter.getClass().getSimpleName() + "\n");

        String[] results = filter.getRecommendations("Finding Dory");

        return results;
    }

    @Autowired
    @Qualifier("contentBasedFilter")
    public void setFilter(Filter filter) {
        this.filter = filter;
        System.out.println("Setter method invoked...");
    }
}
