package io.datajek.spring.basics.movierecommendersystem.lesson2;

public class RecommenderImplementation {
    public String[] recommendMovies(String movie) {
        ContentBasedFilter filter = new ContentBasedFilter();
        String[] results = filter.getRecommendations("Finding Dorry");
        return results;
    }
}
