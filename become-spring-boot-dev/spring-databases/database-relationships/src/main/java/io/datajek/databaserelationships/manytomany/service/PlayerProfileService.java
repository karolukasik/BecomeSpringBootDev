package io.datajek.databaserelationships.manytomany.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.manytomany.PlayerProfile;
import io.datajek.databaserelationships.manytomany.repository.PlayerProfileRepository;


@Service
public class PlayerProfileService {

    @Autowired
    PlayerProfileRepository repo;

    public List<PlayerProfile> allPlayerProfiles() {
        return repo.findAll();
    }

    public PlayerProfile addPlayerProfile(PlayerProfile profile) {
        profile.setId(0);
        return repo.save(profile);
    }

    public PlayerProfile getPlayerProfile(int id) {
        Optional<PlayerProfile> optProfile = repo.findById(id);
        if (optProfile.isEmpty()) {
            throw new EntityNotFoundException("There is no player profile with id " + id);
        }
        return optProfile.get();
    }

    public PlayerProfile updatePlayerProfile(int id, PlayerProfile profile) {
        Optional<PlayerProfile> optProfile = repo.findById(id);
        if (optProfile.isEmpty()) {
            throw new EntityNotFoundException("There is no player profile with id " + id);
        }
        profile.setId(id);
        return repo.save(profile);
    }

    public void deletePlayerProfile(int id) {
        // find the player profile by id if exist
        Optional<PlayerProfile> optProfile = repo.findById(id);
        if (optProfile.isEmpty()) {
            throw new EntityNotFoundException("There is no player profile with id " + id);
        }
        var tempPlayerProfile = optProfile.get();
        // set the playerProfile filed in player object to null
        tempPlayerProfile.getPlayer().setPlayerProfile(null);
        // set the player field of playerProfile as null
        tempPlayerProfile.setPlayer(null);
        // update playerProfile in repository
        repo.save(tempPlayerProfile);
        // finally delete it
        repo.delete(tempPlayerProfile);

    }

}
