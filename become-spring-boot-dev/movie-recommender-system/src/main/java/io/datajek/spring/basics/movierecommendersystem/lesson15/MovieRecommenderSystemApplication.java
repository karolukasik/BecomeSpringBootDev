package io.datajek.spring.basics.movierecommendersystem.lesson15;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {

		var appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

		var recommender = appContext.getBean(RecommenderImplementation.class);

		String favoriteMovie = recommender.getFavouriteMovie();
		System.out.println(favoriteMovie);

		String[] result = recommender.recommendMovies("Finding Dorry");
		System.out.println(Arrays.toString(result));
	}

}
