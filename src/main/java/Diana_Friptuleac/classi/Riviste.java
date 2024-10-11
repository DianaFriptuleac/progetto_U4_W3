package Diana_Friptuleac.classi;

import Diana_Friptuleac.enums.Periodicita;
import jakarta.persistence.*;

@Entity
@Table(name = "riviste")
public class Riviste extends Catalogo {

    @Enumerated(EnumType.STRING)
    @Column(name = "periodicita")
    private Periodicita periodo;

    public Riviste() {
    }

    public Riviste(String titolo, int annoPubblicazione, int nrPagine, Periodicita periodo) {
        super(titolo, annoPubblicazione, nrPagine);
        this.periodo = periodo;
    }

    public Periodicita getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodicita periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodo=" + periodo +
                ", " + super.toString() +
                '}';
    }
}
