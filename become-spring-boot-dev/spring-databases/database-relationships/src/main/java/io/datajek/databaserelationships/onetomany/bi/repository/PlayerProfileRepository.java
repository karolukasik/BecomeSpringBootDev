package io.datajek.databaserelationships.onetomany.bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.datajek.databaserelationships.onetomany.bi.PlayerProfile;

@Repository
public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, Integer> {

}
