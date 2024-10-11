package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Catalogo;
import Diana_Friptuleac.classi.Libri;
import Diana_Friptuleac.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class CatalogoDAO {
    private final EntityManager entityManager;

    public CatalogoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // ********************** 1.Metodo per aggiungere un elemento *********************
    public void saveElement(Catalogo newElement) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newElement);
        transaction.commit();
        System.out.println("L'elemento " + newElement.getTitolo() + " è stato aggiunto con successo!");
    }

    // ************************ 2.Metodo per la rimozione di un elemento del catalogo dato il codice ISBN
    public void deleteElement(UUID isbn) {
        Catalogo foundElement = this.findById(String.valueOf(isbn));
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(foundElement);
        transaction.commit();
        System.out.println("L'elemento " + foundElement.getTitolo() + " è stato rimosso con successo!");
    }


    // *********************** 3.Metodo findById element **********************************
    public Catalogo findById(String id) {
        UUID uuid = UUID.fromString(id);
        Catalogo foundL = entityManager.find(Catalogo.class, uuid);
        if (foundL == null) {
            throw new NotFoundException("L'elemento con ID " + id + " non e stato trovata.");
        }
        return foundL;
    }

    // *********************** 4.Metodo findByPubYear element **********************************
    public List<Catalogo> findByYear(int anno) {
        TypedQuery<Catalogo> query = entityManager.createQuery(
                "SELECT e FROM Catalogo e WHERE e.annoPubblicazione = :anno", Catalogo.class);
        query.setParameter("anno", anno);
        List<Catalogo> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            throw new NotFoundException("Nessun elemento pubblicato in questoo anno " + anno);
        }
        return resultList;
    }

    // *********************** 5.Metodo findByAutore **********************************
    public List<Libri> findByAutore(String autore) {
        return entityManager.createNamedQuery("Libri.findByAutore", Libri.class)
                .setParameter("autore", autore)
                .getResultList();
    }

    // *********************** 6.Metodo findByTitle **********************************
    public List<Catalogo> findByTitle(String titolo) {
        return entityManager.createNamedQuery("Catalogo.findByTitle", Catalogo.class)
                .setParameter("titolo", "%" + titolo + "%")
                .getResultList();
    }


}
