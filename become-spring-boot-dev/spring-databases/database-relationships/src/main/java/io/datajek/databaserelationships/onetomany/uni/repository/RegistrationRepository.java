package io.datajek.databaserelationships.onetomany.uni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.datajek.databaserelationships.onetomany.uni.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
