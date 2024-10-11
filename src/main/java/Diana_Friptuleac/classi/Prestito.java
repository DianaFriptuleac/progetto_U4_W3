package Diana_Friptuleac.classi;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @GeneratedValue
    @Column(name = "id_prestito")
    private UUID idPrestito;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "articolo_id")
    private Catalogo articoloPrestato;

    @Column(name = "data_inizio")
    private LocalDate dataInizioPrestito;

    @Column(name = "data_rPrevista")
    private LocalDate dataRPrevista;

    @Column(name = "data_rEffettiva")
    private LocalDate dataREffettiva;

    public Prestito() {
    }

    public Prestito(Utente utente, Catalogo articoloPrestato, LocalDate dataInizioPrestito, LocalDate dataREffettiva) {
        this.utente = utente;
        this.articoloPrestato = articoloPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRPrevista = dataInizioPrestito.plusDays(30);
        this.dataREffettiva = dataREffettiva;
    }


    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Catalogo getArticoloPrestato() {
        return articoloPrestato;
    }

    public void setArticoloPrestato(Catalogo articoloPrestato) {
        this.articoloPrestato = articoloPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRPrevista() {
        return dataRPrevista;
    }

    public void setDataRPrevista(LocalDate dataRPrevista) {
        this.dataRPrevista = dataRPrevista;
    }

    public LocalDate getDataREffettiva() {
        return dataREffettiva;
    }

    public void setDataREffettiva(LocalDate dataREffettiva) {
        this.dataREffettiva = dataREffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", articoloPrestato=" + articoloPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRPrevista=" + dataRPrevista +
                ", dataREffettiva=" + dataREffettiva +
                '}';
    }
}
