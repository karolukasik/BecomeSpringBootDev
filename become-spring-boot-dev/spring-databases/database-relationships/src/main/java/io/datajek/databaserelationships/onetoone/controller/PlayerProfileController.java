package io.datajek.databaserelationships.onetoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.datajek.databaserelationships.onetoone.PlayerProfile;
import io.datajek.databaserelationships.onetoone.service.PlayerProfileService;

@RestController
public class PlayerProfileController {

    @Autowired
    PlayerProfileService service;

    @GetMapping("/profiles")
    public List<PlayerProfile> getPlayerProfiles() {
        return service.allPlayerProfiles();
    }

    @GetMapping("/profiles/{id}")
    public PlayerProfile getPlayerProfile(@PathVariable int id) {
        return service.getPlayerProfile(id);
    }

    @PostMapping("/profiles")
    public PlayerProfile addPlayerProfile(@RequestBody PlayerProfile PlayerProfile) {
        return service.addPlayerProfile(PlayerProfile);
    }

    @DeleteMapping("/profiles/{id}")
    public void deletePlayerProfile(@PathVariable int id) {
        service.deletePlayerProfile(id);
    }

}
