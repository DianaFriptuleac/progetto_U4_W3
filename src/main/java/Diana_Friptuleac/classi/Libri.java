package Diana_Friptuleac.classi;

import Diana_Friptuleac.enums.GenereLibri;
import jakarta.persistence.*;


@Entity
@Table(name = "libri")
public class Libri extends Catalogo {

    @Column(name = "autore")
    private String autore;

    @Enumerated(EnumType.STRING)
    @Column(name = "genere")
    private GenereLibri genere;

    public Libri() {
    }

    public Libri(String titolo, int annoPubblicazione, int nrPagine, String autore, GenereLibri genere) {
        super(titolo, annoPubblicazione, nrPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public GenereLibri getGenere() {
        return genere;
    }

    public void setGenere(GenereLibri genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere=" + genere +
                ", " + super.toString() +
                '}';
    }
}
