package io.datajek.spingdatajpa;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@NamedQuery(name = "get_all_players", query = "select p from Player p")
@Table(name = "Player")
public class Player {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String nationality;
    private Date birthDate;
    private int titles;

    public Player(String name, String nationality, Date birthDate, int titles) {
        super();
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
    }

}
