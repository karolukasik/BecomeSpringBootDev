package io.datajek.spring.basics.movierecommendersystem.lesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {

		ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

		var filter1 = appContext.getBean(ContentBasedFilter.class);
		var filter2 = appContext.getBean(ContentBasedFilter.class);
		var filter3 = appContext.getBean(ContentBasedFilter.class);

		var filter4 = appContext.getBean(CollaborativeFilter.class);
		var filter5 = appContext.getBean(CollaborativeFilter.class);
		var filter6 = appContext.getBean(CollaborativeFilter.class);

		System.out.println(filter1);
		System.out.println(filter2);
		System.out.println(filter3);
		System.out.println(filter4);
		System.out.println(filter5);
		System.out.println(filter6);

	}

}
