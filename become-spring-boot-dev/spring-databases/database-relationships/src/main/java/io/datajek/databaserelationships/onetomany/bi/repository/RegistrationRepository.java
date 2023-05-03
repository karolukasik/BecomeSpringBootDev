package io.datajek.databaserelationships.onetomany.bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.datajek.databaserelationships.onetomany.bi.Registration;



public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
