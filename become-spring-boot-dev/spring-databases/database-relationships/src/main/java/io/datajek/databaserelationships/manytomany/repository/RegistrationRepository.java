package io.datajek.databaserelationships.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.datajek.databaserelationships.manytomany.Registration;



public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
