package io.datajek.spring.basics.movierecommendersystem.lesson14;

public class CollaborativeFilter implements Filter {

    public String[] getRecommendations(String movie) {
        return new String[] { "Other" };
    }

}
