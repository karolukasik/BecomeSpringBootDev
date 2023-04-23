package io.datajek.databaserelationships.onetomany.bi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.datajek.databaserelationships.onetomany.bi.Player;
import io.datajek.databaserelationships.onetomany.bi.PlayerProfile;
import io.datajek.databaserelationships.onetomany.bi.Registration;
import io.datajek.databaserelationships.onetomany.bi.service.PlayerProfileService;
import io.datajek.databaserelationships.onetomany.bi.service.PlayerService;
import io.datajek.databaserelationships.onetomany.bi.service.RegistrationService;


@RestController
public class PlayerController {

    @Autowired
    PlayerService service;
    @Autowired
    PlayerProfileService profileService;
    @Autowired
    RegistrationService registrationService;



    @GetMapping("/players")
    public List<Player> getPlayers() {
        return service.allPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id) {
        return service.getPlayer(id);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        return service.addPlayer(player);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id) {
        service.deletePlayer(id);
    }

    @PutMapping("/players/{id}/profiles/{profileId}")
    public Player assignDetail(@PathVariable int id, @PathVariable int profileId) {
        PlayerProfile profile = profileService.getPlayerProfile(profileId);
        return service.assignProfile(id, profile);
    }

    @PutMapping("/players/{id}/registrations/{registration_id}")
    public Player assignRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistration(registration_id);
        return service.assignRegistration(id, registration);
    }

}
