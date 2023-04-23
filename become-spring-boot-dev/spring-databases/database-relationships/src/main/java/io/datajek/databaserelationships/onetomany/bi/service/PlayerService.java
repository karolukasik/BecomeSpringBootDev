package io.datajek.databaserelationships.onetomany.bi.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.onetomany.bi.Player;
import io.datajek.databaserelationships.onetomany.bi.PlayerProfile;
import io.datajek.databaserelationships.onetomany.bi.Registration;
import io.datajek.databaserelationships.onetomany.bi.repository.PlayerRepository;


@Service
public class PlayerService {

    @Autowired
    PlayerRepository repo;

    public List<Player> allPlayers() {
        return repo.findAll();
    }

    public Player addPlayer(Player player) {
        player.setId(0);
        return repo.save(player);
    }

    public Player getPlayer(int id) {
        Optional<Player> optPlayer = repo.findById(id);
        if (optPlayer.isEmpty()) {
            throw new EntityNotFoundException("There is no player with id " + id);
        }

        return optPlayer.get();
    }

    public Player updatePlayer(int id, Player player) throws EntityNotFoundException {
        Optional<Player> optPlayer = repo.findById(id);
        if (optPlayer.isEmpty()) {
            throw new EntityNotFoundException("There is no player with id " + id);
        }
        player.setId(id);
        return repo.save(player);
    };

    public void deletePlayer(int id) {
        repo.deleteById(id);
    }

    public Player assignProfile(int id, PlayerProfile profile) throws EntityNotFoundException {
        Optional<Player> optPlayer = repo.findById(id);
        if (optPlayer.isEmpty()) {
            throw new EntityNotFoundException("There is no player with id " + id);
        }
        Player player = repo.findById(id).get();
        player.setPlayerProfile(profile);
        return repo.save(player);
    }

    public Player assignRegistration(int id, Registration registration) {
        Optional<Player> optPlayer = repo.findById(id);
        if (optPlayer.isEmpty()) {
            throw new EntityNotFoundException("There is no player with id " + id);
        }
        Player player = repo.findById(id).get();
        player.registerPlayer(registration);
        return repo.save(player);
    }
}
