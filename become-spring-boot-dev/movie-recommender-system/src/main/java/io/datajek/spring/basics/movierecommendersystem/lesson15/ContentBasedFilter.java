package io.datajek.spring.basics.movierecommendersystem.lesson15;

import org.springframework.stereotype.Component;

@Component("CBF")
//@Component
//@Qualifier("CBF")
public class ContentBasedFilter implements Filter {

    public String[] getRecommendations(String Movie) {
        return new String[] { "Happy Feet", "Ice Age", "Shark Tale" };
    }

}
