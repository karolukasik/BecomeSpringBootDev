package io.datajek.spring.basics.movierecommendersystem.lesson11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {

		var appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

		var recommender = appContext.getBean(RecommenderImplementation.class);

		System.out.println("\n\n" + recommender);

		Movie movieOne = appContext.getBean(Movie.class);
		System.out.println("\n\n" + movieOne);

		Movie movieTwo = appContext.getBean(Movie.class);
		System.out.println("\n\n" + movieTwo);

	}

}
