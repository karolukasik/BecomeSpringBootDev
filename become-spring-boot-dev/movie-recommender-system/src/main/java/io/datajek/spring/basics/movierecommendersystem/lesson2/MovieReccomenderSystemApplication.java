package io.datajek.spring.basics.movierecommendersystem.lesson2;

import java.util.Arrays;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieReccomenderSystemApplication {

	public static void main(String[] args) {
		// SpringApplication.run(MovieReccomenderSystemApplication.class, args);
		RecommenderImplementation recommender = new RecommenderImplementation(new CollaborativeFilter());
		String[] result = recommender.recommendMovies("Finding Dorry");
		System.out.println(Arrays.toString(result));
	}

}
