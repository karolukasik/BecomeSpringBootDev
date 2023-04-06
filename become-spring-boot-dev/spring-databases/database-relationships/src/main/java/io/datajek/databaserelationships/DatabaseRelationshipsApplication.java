package io.datajek.databaserelationships;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.datajek.databaserelationships.onetoone.Player;

@SpringBootApplication
public class DatabaseRelationshipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseRelationshipsApplication.class, args);
		Player pla = new Player("Karo");
		System.out.println(pla);

	}

}
