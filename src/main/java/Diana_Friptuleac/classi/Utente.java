package Diana_Friptuleac.classi;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    @Column(name = "id_tessera")
    private UUID idTessera;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataNascita;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prestito> prestiti;

    public Utente() {
    }

    public Utente(String name, String cognome, LocalDate dataNascita) {
        this.name = name;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public UUID getIdTessera() {
        return idTessera;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "idTessera=" + idTessera +
                ", name='" + name + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }
}
