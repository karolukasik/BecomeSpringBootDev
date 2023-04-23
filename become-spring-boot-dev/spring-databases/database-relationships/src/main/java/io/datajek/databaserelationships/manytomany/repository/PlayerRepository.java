package io.datajek.databaserelationships.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.datajek.databaserelationships.manytomany.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
