package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Utente;
import Diana_Friptuleac.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UtenteDAO {
    private final EntityManager entityManager;

    public UtenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Metodo save utente
    public void saveUtente(Utente newUtente) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newUtente);
        transaction.commit();
        System.out.println("L'utente " + newUtente.getName() + " " + newUtente.getCognome() + " è stato salvato con successo!");
    }


    // Metodo per trovare un utente per ID
    public Utente findById(String userId) {
        UUID uuid = UUID.fromString(userId);  // Converto String in UUID
        Utente found = entityManager.find(Utente.class, uuid);
        if (found == null) {
            throw new NotFoundException("L'utente con l'ID " + userId + " non è stato trovato.");
        }
        return found;
    }

}
