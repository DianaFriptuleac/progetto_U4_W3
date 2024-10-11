package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Prestito;
import Diana_Friptuleac.classi.Utente;
import Diana_Friptuleac.exceptions.ErrorePrestitoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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


            System.out.println("Salvando prestito per utente ID: " + utente.getIdTessera());
            System.out.println("Articolo prestato ISBN: " + newPrestito.getArticoloPrestato().getISBN());


            entityManager.persist(newPrestito);
            transaction.commit();
            System.out.println("Prestito salvato con successo per l'utente: " + utente.getName() + " " + utente.getCognome());

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new ErrorePrestitoException("Errore durante il salvataggio del prestito: " + e.getMessage());
        }
    }
}