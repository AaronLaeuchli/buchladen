package ch.bbw.aal.buchladen.model;

import javax.persistence.*;

@Entity
@Table(name = "genre")
@NamedQuery(name = "Genre.findAll", query = "FROM Genre")
public class Genre {

    @Id
    @Column(name = "genre_id", unique = true)
    private int genre_id;

    @Column(name = "name")
    private String name;

    public Genre() {
    }

    public Genre(int genre_id, String name) {
        this.genre_id = genre_id;
        this.name = name;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genre_id=" + genre_id +
                ", name='" + name + '\'' +
                '}';
    }
}
