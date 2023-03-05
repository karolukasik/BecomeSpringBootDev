package io.datajek.springdata.tennisplayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createTournamentTable() {
        var sql = "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50), LOCATION VARCHAR(50), PRIMARY KEY (ID))";
        jdbcTemplate.execute(sql);
        System.out.println("Table created");
    }

    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM Player";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class));
    }

    public Player getPlayerById(int id) {
        var sqlQuery = "SELECT * FROM Player WHERE ID = ?";
        return jdbcTemplate.queryForObject(sqlQuery,
                new BeanPropertyRowMapper<Player>(Player.class),
                new Object[] { id });
    }

    public int insertPlayer(Player player) {
        var sql = "INSERT INTO PLAYER (ID, Name, Nationality, Birth_date, Titles) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[] { player.getId(), player.getName(), player.getNationality(),
                player.getBirthDate(), player.getTitles() });

    }

    public int updatePlayer(Player player) {
        var sql = "UPDATE PLAYER " + "SET Name = ?, Nationality = ?, Birth_date = ?, Titles = ?" + "WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[] { player.getName(), player.getNationality(), player.getBirthDate(),
                player.getTitles(), player.getId() });
    }

    public int deletePlayerById(int id) {
        var sql = "DELETE FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[] { id });
    }
}
