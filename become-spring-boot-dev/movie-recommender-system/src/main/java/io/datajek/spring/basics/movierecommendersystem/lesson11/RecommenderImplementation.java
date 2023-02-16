package io.datajek.spring.basics.movierecommendersystem.lesson11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RecommenderImplementation {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Filter filter;

    public String[] recommendMovies(String movie) {

        System.out.println("Name of the filter in use: " + filter.getClass().getSimpleName() + "\n");

        String[] results = filter.getRecommendations("Finding Dorry");

        return results;
    }

    @Autowired
    public void setfilter(Filter filter) {
        logger.info("In RecommenderImplementation setter method..dependency injection");
        this.filter = filter;
    }

    @PostConstruct
    public void anyName() {
        //initialization
        logger.info("In RecommederImplementation postConstruct method");
    }

}
