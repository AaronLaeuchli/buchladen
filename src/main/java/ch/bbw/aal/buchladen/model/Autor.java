package ch.bbw.aal.buchladen.model;

import javax.persistence.*;

/**
 * Class: Autor
 *
 * @author Aaron Läuchli
 * @version 16.11.2021
 */

@Entity
@Table(name = "Autor")
@NamedQuery(name = "Autor.findAll", query = "FROM Autor")
public class Autor {

    @Id
    @Column(name = "AutorId", unique = true)
    private int autorId;

    @Column(name = "Vorname")
    private String vorname;

    @Column(name = "Nachname")
    private String nachname;

    public Autor() {
    }

    public Autor(int autorId, String vorname, String nachname) {
        this.autorId = autorId;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "autorId=" + autorId +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                '}';
    }
}
