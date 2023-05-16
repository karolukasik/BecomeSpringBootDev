package io.datajek.databaserelationships.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.datajek.databaserelationships.manytomany.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

}
