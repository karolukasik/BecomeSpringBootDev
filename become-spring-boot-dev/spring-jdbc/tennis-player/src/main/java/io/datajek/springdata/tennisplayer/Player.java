package io.datajek.springdata.tennisplayer;

import java.sql.Date;

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
public class Player {
    private int id;
    private String name;
    private String nationality;
    private Date birthDate;
    private int titles;

}
