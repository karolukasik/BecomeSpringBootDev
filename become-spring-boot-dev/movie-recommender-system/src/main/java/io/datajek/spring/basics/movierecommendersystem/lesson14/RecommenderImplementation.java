package io.datajek.spring.basics.movierecommendersystem.lesson14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class RecommenderImplementation {

    @Autowired
    @Qualifier("CBF")
    private Filter filter;

    public RecommenderImplementation(Filter filter) {
        this.filter = filter;
    }

    public RecommenderImplementation() {
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    // use a filter to find recommendations
    public String[] recommendMovies(String movie) {

        String[] results = filter.getRecommendations("Finding Dory");

        return results;
    }

    public Filter getFilter() {
        return filter;
    }

}
