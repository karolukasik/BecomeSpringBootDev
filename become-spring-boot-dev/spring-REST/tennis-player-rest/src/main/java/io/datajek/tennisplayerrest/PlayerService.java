package io.datajek.tennisplayerrest;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repo;

    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    public Player getPlayer(Long id) throws PlayerNotFoundException {
        Optional<Player> optPlayer = repo.findById(id);

        if (optPlayer.isEmpty()) {
            throw new PlayerNotFoundException("Player with id " + id + " was not found");
        }

        return optPlayer.get();
    }

    public Player addPlayer(Player player) {
        return repo.save(player);
    }

    public Player updatePlayer(Long id, Player player) {
        Optional<Player> optPlayer = repo.findById(id);
        if (optPlayer.isEmpty()) {
            throw new PlayerNotFoundException("Player with id " + id + " was not found");
        }
        player.setId(id);
        return repo.save(player);
    }

    public Player patch(Long id, Map<String, Object> playerPatch) throws NoSuchElementException {
        Optional<Player> optPlayer = repo.findById(id);
        if (optPlayer.isEmpty()) {
            throw new PlayerNotFoundException("The player with id" + id + "does not exist");
        }

        playerPatch.forEach((key, value) -> {
            Field field = ReflectionUtils.findRequiredField(Player.class, key);
            ReflectionUtils.setField(field, optPlayer.get(), value);
        });

        return repo.save(optPlayer.get());
    }

    @Transactional
    public void updateTitles(Long id, int titles) {
        Optional<Player> optPlayer = repo.findById(id);
        if (optPlayer.isEmpty()) {
            throw new PlayerNotFoundException("The player with id" + id + "does not exist");
        }
        repo.updateTitles(id, titles);
    }

    public void deletePlayer(Long id) {
        Optional<Player> optPlayer = repo.findById(id);

        if (optPlayer.isEmpty()) {
            throw new PlayerNotFoundException("The player with id" + id + "does not exist");
        }
        repo.deleteById(id);
    }

}
