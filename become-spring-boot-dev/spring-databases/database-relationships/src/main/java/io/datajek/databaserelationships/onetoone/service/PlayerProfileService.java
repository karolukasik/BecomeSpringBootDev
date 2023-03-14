package io.datajek.databaserelationships.onetoone.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.onetoone.PlayerProfile;
import io.datajek.databaserelationships.onetoone.repository.PlayerProfileRepository;

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

    public PlayerProfile getPlayerProfile(int id) throws EntityNotFoundException {
        Optional<PlayerProfile> optProfile = repo.findById(id);
        if (optProfile.isEmpty()) {
            throw new EntityNotFoundException("There is no player profile with id " + id);
        }
        return optProfile.get();
    }

    public PlayerProfile updatePlayerProfile(int id, PlayerProfile profile) throws EntityNotFoundException {
        Optional<PlayerProfile> optProfile = repo.findById(id);
        if (optProfile.isEmpty()) {
            throw new EntityNotFoundException("There is no player profile with id " + id);
        }
        profile.setId(id);
        return repo.save(profile);
    }

    public void deletePlayerProfile(int id) {
        Optional<PlayerProfile> optProfile = repo.findById(id);
        if (optProfile.isEmpty()) {
            throw new EntityNotFoundException("There is no player profile with id " + id);
        }
        repo.deleteById(id);

    }



}
