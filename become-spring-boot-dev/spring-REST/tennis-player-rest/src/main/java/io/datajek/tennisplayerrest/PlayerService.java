package io.datajek.tennisplayerrest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repo;

    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    public Player getPlayer(Long id) throws RuntimeException {
        Optional<Player> tempPlayer = repo.findById(id);
        Player p = null;

        if (tempPlayer.isPresent()) {
            p = tempPlayer.get();
        } else {
            throw new RuntimeException("Player with id " + id + " was not found");
        }

        return p;
    }

    public Player addPlayer(Player player) {
        return repo.save(player);
    }
}
