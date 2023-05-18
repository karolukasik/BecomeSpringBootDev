package io.datajek.unittesting;

public class ContentBasedFilter implements Filter {

    @Override
    public String[] getRecommendations(String movie) {
        // implement logic of content based filter
        return new String[] { "Happy Feet", "Ice Age", "Shark Tale" };
    }

}
