package Diana_Friptuleac.classi;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@NamedQuery(name = "Catalogo.findByTitle", query = "SELECT e FROM Catalogo e WHERE e.titolo LIKE :titolo")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "catalogo")
public abstract class Catalogo {
    @Id
    @GeneratedValue
    @Column(name = "ISBN")
    private UUID ISBN;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;

    @Column(name = "nr_pagine")
    private int nrPagine;


    public Catalogo() {
    }

    public Catalogo(String titolo, int annoPubblicazione, int nrPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.nrPagine = nrPagine;
    }

    public UUID getISBN() {
        return ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNrPagine() {
        return nrPagine;
    }

    public void setNrPagine(int nrPagine) {
        this.nrPagine = nrPagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", nrPagine=" + nrPagine +
                '}';
    }
}
