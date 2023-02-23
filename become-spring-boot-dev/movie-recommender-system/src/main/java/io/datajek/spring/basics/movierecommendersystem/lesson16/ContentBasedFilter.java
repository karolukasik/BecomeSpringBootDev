package io.datajek.spring.basics.movierecommendersystem.lesson16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CBF")
// @Component
// @Qualifier("CBF")
public class ContentBasedFilter implements Filter {

    @Autowired
    private Movie movie;

    public ContentBasedFilter() {
        super();
    }

    // getRecommendations takes a movie as input and returns a list of similar
    // movies
    public String[] getRecommendations(String movie) {
        System.out.println(movie);
        // calculate similarity between movies
        System.out.println("are we here?");
        System.out.println(this.movie);
        // return movie recommendations
        return new String[] { "Happy Feet", "Ice Age", "Shark Tale" };
    }

}
