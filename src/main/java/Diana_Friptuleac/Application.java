package Diana_Friptuleac;

import Diana_Friptuleac.classi.*;
import Diana_Friptuleac.dao.CatalogoDAO;
import Diana_Friptuleac.dao.PrestitoDAO;
import Diana_Friptuleac.dao.UtenteDAO;
import Diana_Friptuleac.enums.GenereLibri;
import Diana_Friptuleac.enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");
    private static CatalogoDAO catalogoDAO;

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        //DAO
        CatalogoDAO catalogoDAO = new CatalogoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        // Salvo libri
        Libri l1 = new Libri("Il Signore degli Anelli", 1954, 1216, "Tolkien", GenereLibri.FANTASY);
        Libri l2 = new Libri("Il Nome della Rosa", 1980, 512, "Umberto Eco", GenereLibri.GIALLO);
        Libri l3 = new Libri("Introduzione allo studio della bibliografia", 2020, 231, " Andrea Capaccioni", GenereLibri.BIOGRAFIA);
        Libri l4 = new Libri("Harry Potter e la Pietra Filosofale", 1997, 223, "J.K. Rowling", GenereLibri.FANTASY);
        Libri l5 = new Libri("Sissi", 2023, 230, "Sperling Kupfe", GenereLibri.ROMANZI);


      /*  catalogoDAO.saveLibro(l1);
        catalogoDAO.saveLibro(l2);
        catalogoDAO.saveLibro(l3);
        catalogoDAO.saveLibro(l4);
        catalogoDAO.saveLibro(l5);

       */

        //Salvo riviste
        Riviste r1 = new Riviste("Focus", 2024, 120, Periodicita.MENSILE);
        Riviste r2 = new Riviste("Forbes", 2024, 150, Periodicita.MENSILE);
        Riviste r3 = new Riviste("Grazia", 2024, 85, Periodicita.SETTIMANALE);
        Riviste r4 = new Riviste("L'espresso", 2023, 130, Periodicita.SEMESTRALE);
        Riviste r5 = new Riviste("Giallo Zafferano", 2024, 110, Periodicita.MENSILE);

      /*  catalogoDAO.saveRivista(r1);
        catalogoDAO.saveRivista(r2);
        catalogoDAO.saveRivista(r3);
        catalogoDAO.saveRivista(r4);
        catalogoDAO.saveRivista(r5);
        */

        //Savo utenti
        Utente u1 = new Utente("Anna", "Margini", LocalDate.of(19886, 5, 24));
        Utente u2 = new Utente("Luca", "Biagi", LocalDate.of(1984, 3, 28));
        Utente u3 = new Utente("Marina", "Voli", LocalDate.of(1995, 8, 30));
        Utente u4 = new Utente("Giulia", "Fossi", LocalDate.of(2000, 9, 10));
        Utente u5 = new Utente("Giovanni", "Bianchi", LocalDate.of(2000, 2, 5));

       /* utenteDAO.saveUtente(u1);
        utenteDAO.saveUtente(u2);
        utenteDAO.saveUtente(u3);
        utenteDAO.saveUtente(u4);
        utenteDAO.saveUtente(u5);

        */

        //Cerco gli utenti per id


        Utente uFind1 = utenteDAO.findById("3e4b657f-e661-4b29-aa22-f0a08eb6f5df");
        Utente uFind2 = utenteDAO.findById("97dfa489-52ed-4476-be98-7b306c1d6cfb");
        Utente uFind3 = utenteDAO.findById("a344bfe4-0f49-4691-a83c-d29ddcc450be");
        Utente uFind4 = utenteDAO.findById("bac439d1-187b-451a-91e5-18a5ff131c76");
        Utente uFind5 = utenteDAO.findById("f5c25752-d7df-4d10-a4cd-90aeb2dd5f0a");

        //Cerco articoli per id
        Catalogo lP1 = catalogoDAO.findByIdL("449452ff-c087-4edc-aa0f-76092503b9a1");
        Catalogo lP2 = catalogoDAO.findByIdL("9d1c5f2c-3b9c-4210-8443-7708725edd5b");
        Catalogo lP3 = catalogoDAO.findByIdL("b4a88419-da17-42eb-8a69-3f4f9ecf7344");
        Catalogo lP4 = catalogoDAO.findByIdL("dd3f7248-b74d-4674-b7ad-661213076206");
        Catalogo lP5 = catalogoDAO.findByIdL("ebf20df5-1ff0-4d6a-8b97-97dd39191fc7");

        //Save prestiti
        Prestito p1 = new Prestito(uFind1, lP1, LocalDate.now(), null);
        Prestito p2 = new Prestito(uFind2, lP2, LocalDate.of(2024, 10, 8), null);
        Prestito p3 = new Prestito(uFind3, lP3, LocalDate.of(2024, 9, 20), null);
        Prestito p4 = new Prestito(uFind4, lP4, LocalDate.of(2024, 9, 30), null);
        Prestito p5 = new Prestito(uFind5, lP5, LocalDate.now(), null);


      /*  prestitoDAO.savePrestito(p1);
        prestitoDAO.savePrestito(p2);
        prestitoDAO.savePrestito(p3);
        prestitoDAO.savePrestito(p4);
        prestitoDAO.savePrestito(p5);*/


        em.close();
        emf.close();


    }
}
