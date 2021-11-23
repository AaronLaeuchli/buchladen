package ch.bbw.aal.buchladen.model;


import javax.persistence.*;

/**
 * Class: Buch
 *
 * @author Aaron Läuchli
 * @version 16.11.2021
 */

@Entity
@Table(name = "Buch")
@NamedQuery(name = "Buch.findAll", query = "FROM Buch ")
public class Buch {

    @Id
    @Column(name = "BuchId", unique = true)
    private int buchId;

    @Column(name = "BuchTitel")
    private String buchTitel;

    @Column(name = "AnzahlSeiten")
    private int anzSeiten;

    @ManyToOne
    @JoinColumn(name = "AutorIdfs")
    private Autor autor;

    public Buch(int buchId, String buchTitel, int anzSeiten, Autor autor) {
        this.buchId = buchId;
        this.buchTitel = buchTitel;
        this.anzSeiten = anzSeiten;
        this.autor = autor;
    }

    public Buch() {

    }



    public int getBuchId() {
        return buchId;
    }

    public void setBuchId(int buchId) {
        this.buchId = buchId;
    }

    public String getBuchTitel() {
        return buchTitel;
    }

    public void setBuchTitel(String buchTitel) {
        this.buchTitel = buchTitel;
    }

    public int getAnzSeiten() {
        return anzSeiten;
    }

    public void setAnzSeiten(int anzSeiten) {
        this.anzSeiten = anzSeiten;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
