package io.datajek.databaserelationships.onetomany.uni.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.onetomany.uni.Registration;
import io.datajek.databaserelationships.onetomany.uni.Tournament;
import io.datajek.databaserelationships.onetomany.uni.repository.TournamentRepository;

@Service
public class TournamentService {

    @Autowired
    TournamentRepository repo;

    public Tournament addTournament(Tournament tournament) {
        tournament.setId(0);
        return repo.save(tournament);
    }

    public List<Tournament> allTournaments() {
        return repo.findAll();
    }

    public Tournament getTournament(int id) {
        Optional<Tournament> optTrnm = repo.findById(id);
        if (optTrnm.isEmpty()) {
            throw new EntityNotFoundException(String.format("The tournament with id %i was not found", id));
        }
        return optTrnm.get();
    }

    public Tournament updateTournament(int id, Tournament tournament) {
        Optional<Tournament> optTrnm = repo.findById(id);
        if (optTrnm.isEmpty()) {
            throw new EntityNotFoundException("The tournament with id " + id + " was not found");
        }
        tournament.setId(id);
        return repo.save(tournament);
    }

    public void deleteTournament(int id) {
        Optional<Tournament> optTrnm = repo.findById(id);
        if (optTrnm.isEmpty()) {
            throw new EntityNotFoundException("The tournament with id " + id + " was not found");
        }
        repo.deleteById(id);
    }

    public Tournament addRegistration(int id, Registration registration){
        Tournament tournament = repo.getReferenceById(id);
        tournament.addRegistration(registration);
        return repo.save(tournament);
    }

    public Tournament removeRegistration(int id, Registration registration) {
		Tournament tournament = repo.findById(id).get();
		tournament.removeRegistration(registration);
		return repo.save(tournament);
	}
}
