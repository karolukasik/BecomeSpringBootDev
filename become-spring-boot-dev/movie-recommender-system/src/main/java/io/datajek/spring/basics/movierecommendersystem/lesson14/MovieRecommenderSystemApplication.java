package io.datajek.spring.basics.movierecommendersystem.lesson14;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {

		// ApplicationContext manages the beans and dependencies
		var appContext = new ClassPathXmlApplicationContext("appContext.xml");

		System.out.println("\nBeans loaded: ");
		System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));

		// use ApplicationContext to find which filter is being used
		var recommender = appContext.getBean("recommenderImplementation", RecommenderImplementation.class);

		// print dependency
		System.out.println("\nDependency: " + recommender.getFilter() + "\n");

		appContext.close();

	}

}
