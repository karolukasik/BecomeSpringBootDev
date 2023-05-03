package io.datajek.spingdatajpa;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisPlayerSpringDataApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlayerSpringDataRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n\n Inserting player: {}\n",
				repo.save(new Player("Djokovic", "Serbia",
						Date.valueOf("1987-05-22"), 81)));
		logger.info("\n\n Inserting player: {}\n",
				repo.save(new Player("Monfils", "France", Date.valueOf("1986-09-01"),
						10)));
		logger.info("\n\n>> Inserting Player: {}\n", repo.save(
				new Player("Thiem", "Austria",
						new Date(System.currentTimeMillis()), 17)));

		logger.info("\n\n>> Player with nationality France: {}\n", repo.findByNationality("France"));

	}

}
