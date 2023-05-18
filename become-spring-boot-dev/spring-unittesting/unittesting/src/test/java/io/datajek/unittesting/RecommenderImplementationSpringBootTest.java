package io.datajek.unittesting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecommenderImplementationSpringBootTest {

	@Autowired
	private RecommenderImplementation recommenderImpl;

	@Test
	void testRecommendMovies() {
		String[] result = recommenderImpl.recommendMovies("Finding Dory");
		assertArrayEquals(new String[] { "Finding Nemo", "Ice Age", "Toy Story" }, result);
	}

}
