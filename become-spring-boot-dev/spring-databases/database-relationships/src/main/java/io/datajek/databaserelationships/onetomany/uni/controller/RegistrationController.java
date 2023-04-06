package io.datajek.databaserelationships.onetomany.uni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import io.datajek.databaserelationships.onetomany.uni.Registration;
import io.datajek.databaserelationships.onetomany.uni.service.RegistrationService;

@Controller
public class RegistrationController {

    @Autowired
    RegistrationService service;

    @GetMapping
    public List<Registration> allRegistrations() {
        return service.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public Registration getRegistration(@PathVariable int id) {
        return service.getRegistration(id);
    }

    @PostMapping
    public Registration addRegistration(@RequestBody Registration registration) {
        return service.addRegistration(registration);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable int id) {
        service.deleteRegistration(id);
    }

}
