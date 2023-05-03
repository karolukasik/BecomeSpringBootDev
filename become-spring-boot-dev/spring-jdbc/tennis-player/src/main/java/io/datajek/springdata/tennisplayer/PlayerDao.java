package io.datajek.springdata.tennisplayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
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

    public List<Player> getPlayerByNationality(String nationality) {
        var sql = "SELECT * FROM PLAYER WHERE NATIONALITY = ?";

        return jdbcTemplate.query(sql, new PlayerMapper(), new Object[] { nationality });
    }

    private static final class PlayerMapper implements RowMapper<Player> {

        @Override
        @Nullable
        public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();
            player.setId(rs.getInt("id"));
            player.setName(rs.getString("name"));
            player.setNationality(rs.getString("nationality"));
            player.setBirthDate(rs.getDate("birth_date"));
            player.setTitles(rs.getInt("titles"));

            return player;
        }

    }
}
