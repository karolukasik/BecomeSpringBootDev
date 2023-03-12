package io.datajek.tennisplayerrest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Modifying
    @Query("UPDATE Player p set p.titles = :titles where p.id = :id")
    void updateTitles(@Param("id") Long id, @Param("titles") int titles);
}
