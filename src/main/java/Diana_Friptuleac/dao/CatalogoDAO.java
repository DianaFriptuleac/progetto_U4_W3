package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Libri;
import Diana_Friptuleac.classi.Riviste;
import Diana_Friptuleac.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class CatalogoDAO {
    private final EntityManager entityManager;

    public CatalogoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Metodo save libro
    public void saveLibro(Libri newLibro) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newLibro);
        transaction.commit();
        System.out.println("Il libro " + newLibro.getTitolo() + " è stato aggiunto con successo!");
    }

    //Metodo save rivista
    public void saveRivista(Riviste newRivista) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newRivista);
        transaction.commit();
        System.out.println("Ia rivista " + newRivista.getTitolo() + " è stata salvata con successo!");
    }

    //Metodo findById Libri
    public Libri findByIdL(String id) {
        UUID uuid = UUID.fromString(id);
        Libri foundL = entityManager.find(Libri.class, uuid);
        if (foundL == null) {
            throw new NotFoundException("Il libro con ID " + id + " non trovata.");
        }
        return foundL;
    }

    //Metodo findById Riviste
    public Riviste findByIdR(String catalogoId) {
        UUID uuid = UUID.fromString(catalogoId);
        Riviste foundR = entityManager.find(Riviste.class, catalogoId);
        if (foundR == null) {
            throw new NotFoundException("La rivista con ID " + catalogoId + " non trovata.");
        }
        return foundR;
    }

}
