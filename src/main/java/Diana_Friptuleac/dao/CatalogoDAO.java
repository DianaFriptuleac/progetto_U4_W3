package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Libri;
import Diana_Friptuleac.classi.Riviste;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}
