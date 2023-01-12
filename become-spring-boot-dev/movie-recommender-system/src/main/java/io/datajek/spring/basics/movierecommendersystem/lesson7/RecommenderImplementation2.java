package io.datajek.spring.basics.movierecommendersystem.lesson7;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation2 {

    //@Autowired
   // @Qualifier("CBF")
    private Filter contentBasedFilter;

    public String[] recommendMovies(String movie) {

        System.out.println("Name of the filter in use: " + contentBasedFilter.getClass().getSimpleName() + "\n");

        String[] results = contentBasedFilter.getRecommendations("Finding Dorry");

        return results;
    }
}
