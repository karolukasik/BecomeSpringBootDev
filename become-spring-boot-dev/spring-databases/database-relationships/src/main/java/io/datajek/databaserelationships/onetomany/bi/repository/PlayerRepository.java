package io.datajek.databaserelationships.onetomany.bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.datajek.databaserelationships.onetomany.bi.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
