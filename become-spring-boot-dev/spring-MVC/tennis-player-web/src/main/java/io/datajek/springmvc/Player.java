package io.datajek.springmvc;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private int id;
    private String name;
    private String nationality;
    private Date birthDate;
    private int titles;
}
