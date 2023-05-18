package io.datajek.unittesting;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CollaborativeFilter implements Filter {

    @Override
    public String[] getRecommendations(String movie) {
        // logic of collaborative filter
        return new String[] { "Finding Nemo", "Ice Age", "Toy Story" };
    }

}
