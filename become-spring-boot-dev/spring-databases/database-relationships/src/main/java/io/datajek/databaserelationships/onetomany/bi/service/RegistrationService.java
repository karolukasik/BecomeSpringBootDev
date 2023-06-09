package io.datajek.databaserelationships.onetomany.bi.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.onetomany.bi.Registration;
import io.datajek.databaserelationships.onetomany.bi.repository.RegistrationRepository;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository repo;

    public Registration addRegistration(Registration registration) {
        registration.setId(0);
        return repo.save(registration);
    }

    public io.datajek.databaserelationships.onetomany.bi.Registration getRegistration(int id) {
        Optional<Registration> optReg = repo.findById(id);
        if (optReg.isEmpty()) {
            throw new EntityNotFoundException("Registration not found, id: " + id);
        }
        return optReg.get();
    }

    public List<Registration> allRegistrations() {
        return repo.findAll();
    }

    public void deleteRegistration(int id) {
        Optional<Registration> optReg = repo.findById(id);
        if (optReg.isEmpty()) {
            throw new EntityNotFoundException("The registration with id " + id + " was not found");
        }
        repo.deleteById(id);
    }
}
