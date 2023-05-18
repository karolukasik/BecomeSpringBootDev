package io.datajek.unittesting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class RecommenderImplementationTest {

    @Test
    void testRecommendMoviesWithCollaborativeFilter() {
        var recommenderImplementation = new RecommenderImplementation(new CollaborativeFilter());
        String[] result = recommenderImplementation.recommendMovies("Finding Dory");
        assertArrayEquals(new String[] { "Finding Nemo", "Ice Age", "Toy Story" }, result);
    }

    @Test
    void testRecommendMovies_withContentBasedFilter() {
        RecommenderImplementation recommenderImpl = new RecommenderImplementation(
                new ContentBasedFilter());
        assertArrayEquals(new String[] { "Happy Feet", "Ice Age", "Shark Tale" },
                recommenderImpl.recommendMovies("Finding Dory"));
    }
}
