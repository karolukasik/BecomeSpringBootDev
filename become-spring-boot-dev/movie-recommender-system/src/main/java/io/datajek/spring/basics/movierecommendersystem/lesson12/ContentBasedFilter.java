package io.datajek.spring.basics.movierecommendersystem.lesson12;

import org.springframework.beans.factory.annotation.Qualifier;

import jakarta.inject.Named;

@Named
@Qualifier("CBF")
public class ContentBasedFilter implements Filter {

    public String[] getRecommendations(String Movie) {
        return new String[] { "Happy Feet", "Ice Age", "Shark Tale" };
    }

}
