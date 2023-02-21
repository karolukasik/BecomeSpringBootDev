package io.datajek.spring.basics.movierecommendersystem.lesson14;

public class RecommenderImplementation {

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

}
