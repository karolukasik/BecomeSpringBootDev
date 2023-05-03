package io.datajek.spring.basics.movierecommendersystem.lesson16;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {

		var appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

		var recommender = appContext.getBean(RecommenderImplementation.class);

		String[] result = recommender.recommendMovies("Finding Dory");
		System.out.println(Arrays.toString(result));

	}

}
