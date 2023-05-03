package io.datajek.spring.basics.movierecommendersystem.lesson8;


import org.springframework.stereotype.Component;

@Component
public class ContentBasedFilter implements Filter {

    public ContentBasedFilter() {
        super();
        System.out.println("content-based filter constructor called");
    }

    public String[] getRecommendations(String Movie) {
        return new String[] { "Happy Feet", "Ice Age", "Shark Tale" };
    }

}
