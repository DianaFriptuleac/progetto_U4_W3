package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Prestito;
import Diana_Friptuleac.classi.Utente;
import Diana_Friptuleac.exceptions.ErrorePrestitoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.UUID;

public class PrestitoDAO {
    private final EntityManager entityManager;

    public PrestitoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //Metodo per salvare il prestito
    public void savePrestito(Prestito newPrestito) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Utente utente = newPrestito.getUtente();
            if (utente == null || utente.getIdTessera() == null) {
                throw new ErrorePrestitoException("Errore!!! Utente non trovato o ID utente mancante per questo prestito!");
            }
            entityManager.persist(newPrestito);
            transaction.commit();
            System.out.println("Prestito salvato correttamente per l'utente ID: " + utente.getIdTessera());
        } catch (Exception e) {
            //annulo tutto
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new ErrorePrestitoException("Errore durante il salvataggio del prestito: " + e.getMessage());
        }
    }

    // *********************** 7.Metodo findByPrestito **********************************
    public List<Prestito> findByPrestito(UUID idTessera) {
        String query = "SELECT p FROM Prestito p WHERE p.utente.idTessera = :idTessera AND p.dataEffettiva IS NULL";
        return entityManager.createQuery(query, Prestito.class)
                .setParameter("idTessera", idTessera)
                .getResultList();
    }

    // *********************** 8.Metodo findByPScaduto **********************************
    public List<Prestito> findByPScaduto() {
        String query = "SELECT p FROM Prestito p WHERE p.dataPrevista < CURRENT_DATE AND p.dataEffettiva IS NULL";
        return entityManager.createQuery(query, Prestito.class)
                .getResultList();
    }

}
