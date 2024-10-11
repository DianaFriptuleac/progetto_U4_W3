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
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");
    private static CatalogoDAO catalogoDAO;

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        //DAO
        CatalogoDAO catalogoDAO = new CatalogoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        //****************************** 1. Aggiunta di un elemento del catalogo ************************************
        // Salvo libri
        Libri l1 = new Libri("Il Signore degli Anelli", 1954, 1216, "Tolkien", GenereLibri.FANTASY);
        Libri l2 = new Libri("Il Nome della Rosa", 1980, 512, "Umberto Eco", GenereLibri.GIALLO);
        Libri l3 = new Libri("Introduzione allo studio della bibliografia", 2020, 231, " Andrea Capaccioni", GenereLibri.BIOGRAFIA);
        Libri l4 = new Libri("Harry Potter e la Pietra Filosofale", 1997, 223, "J.K. Rowling", GenereLibri.FANTASY);
        Libri l5 = new Libri("Sissi", 2023, 230, "Sperling Kupfe", GenereLibri.ROMANZI);


        /*catalogoDAO.saveElement(l1);
        catalogoDAO.saveElement(l2);
        catalogoDAO.saveElement(l3);
        catalogoDAO.saveElement(l4);
        catalogoDAO.saveElement(l5);*/


        //Salvo riviste
        Riviste r1 = new Riviste("Focus", 2024, 120, Periodicita.MENSILE);
        Riviste r2 = new Riviste("Forbes", 2024, 150, Periodicita.MENSILE);
        Riviste r3 = new Riviste("Grazia", 2024, 85, Periodicita.SETTIMANALE);
        Riviste r4 = new Riviste("L'espresso", 2023, 130, Periodicita.SEMESTRALE);
        Riviste r5 = new Riviste("Giallo Zafferano", 2024, 110, Periodicita.MENSILE);

      /*  catalogoDAO.saveElement(r1);
        catalogoDAO.saveElement(r2);
        catalogoDAO.saveElement(r3);
        catalogoDAO.saveElement(r4);
        catalogoDAO.saveElement(r5);

       */


        //********************************* 2.Rimozione di un elemento del catalogo dato un codice ISBN ********
        //catalogoDAO.deleteElement(UUID.fromString("9d1c5f2c-3b9c-4210-8443-7708725edd5b"));

        //********************************** 3.Ricerca per ISBN ******************************
        Catalogo elementById1 = catalogoDAO.findById("20f0ffec-604e-4984-a1ad-f7fb4a356eea");
        Catalogo elementById2 = catalogoDAO.findById("24ea04ec-b6e8-4772-85f4-f4d8671caaba");
        System.out.println("Elemento trovato: " + elementById1);
        System.out.println("Elemento trovato: " + elementById2);


        //********************************** 4.Ricerca per anno pubblicazione ******************************
        List<Catalogo> elementByYear1 = catalogoDAO.findByYear(2024);
        List<Catalogo> elementByYear2 = catalogoDAO.findByYear(1997);
        System.out.println("******************* Elementi trovati per l'anno 2024: ******************");
        for (Catalogo catalogo : elementByYear1) {
            System.out.println(catalogo);
        }
        System.out.println();

        System.out.println("******************** Elementi trovati per l'anno 1997: *******************");
        for (Catalogo catalogo : elementByYear2) {
            System.out.println(catalogo);
        }
        System.out.println();

        //********************************** 5.Ricerca per autore ******************************
        List<Libri> libriPerAutore = catalogoDAO.findByAutore("Umberto Eco");
        System.out.println("******************** Libri scritti da Umberto Eco: *******************");
        for (Libri libro : libriPerAutore) {
            System.out.println(libro);
        }

        System.out.println();

        //********************************** 6.Ricerca per titolo o parte di esso ***********************
        List<Catalogo> elemntoPerTitolo = catalogoDAO.findByTitle("Forbes");
        System.out.println("******************** Elemento con il titolo Forbes: *******************");
        System.out.println(elemntoPerTitolo);


        //----------- Savo utenti
        Utente u1 = new Utente("Anna", "Margini", LocalDate.of(19886, 5, 24));
        Utente u2 = new Utente("Luca", "Biagi", LocalDate.of(1984, 3, 28));
        Utente u3 = new Utente("Marina", "Voli", LocalDate.of(1995, 8, 30));


        utenteDAO.saveUtente(u1);
        utenteDAO.saveUtente(u2);
        utenteDAO.saveUtente(u3);


        //Cerco gli utenti per id
        Utente uFind1 = utenteDAO.findById("f5c25752-d7df-4d10-a4cd-90aeb2dd5f0a");
        Utente uFind2 = utenteDAO.findById("f7d67e34-3ca3-4e22-89de-58d0d0db6b47");

        System.out.println("Utente trovato 1: " + uFind1.getIdTessera());
        System.out.println("Utente trovato 2: " + uFind2.getIdTessera());


        //Cerco elementi per Id


        Prestito p1 = new Prestito(uFind1, elementById2, LocalDate.now(), null);
        System.out.println("Prestito creato con utente ID: " + p1.getUtente().getIdTessera());
        Prestito p2 = new Prestito(uFind2, elementById2, LocalDate.of(2024, 10, 8), LocalDate.of(2024, 11, 30));
        System.out.println("Prestito creato con utente ID: " + p2.getUtente().getIdTessera());

        // Salva i prestiti nel database
        //prestitoDAO.savePrestito(p1);
        //  prestitoDAO.savePrestito(p2);


        em.close();
        emf.close();

        //******************** 7.Ricerca degli elementi attualmente in prestito dato un numero di tessera utente ***********************
        List<Prestito> prestitiAttivi = prestitoDAO.findByPrestito(uFind1.getIdTessera());
        System.out.println("Prestiti attualmente in corso per gli utente: ");
        for (Prestito prestito : prestitiAttivi) {
            System.out.println(prestito);
        }

        //******************** 7.Ricerca per prestiti scaduti ***********************
        List<Prestito> prestitiScaduti = prestitoDAO.findByPScaduto();
        System.out.println("Prestiti scaduti per: ");
        for (Prestito prestito : prestitiScaduti) {
            System.out.println(prestito);
        }


    }
}
