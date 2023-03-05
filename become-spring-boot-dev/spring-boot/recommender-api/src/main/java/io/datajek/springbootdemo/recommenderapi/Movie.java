package io.datajek.springbootdemo.recommenderapi;

import lombok.Getter;

@Getter
public class Movie {
    int id;
    String name;
    double rating;

    public Movie() {
        super();
    }

    public Movie(int id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie [id= " + id + ", name= " + name + ", rating=" + rating + "]";
    }
}
