package Diana_Friptuleac;

import Diana_Friptuleac.classi.Catalogo;
import Diana_Friptuleac.classi.Libri;
import Diana_Friptuleac.classi.Riviste;
import Diana_Friptuleac.classi.Utente;
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


        //********************************* 2.Rimozione di un elemento del catalogo dato un codice ISBN *****************************
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
        System.out.println("Elemento trovato: " + uFind2);


        //Save prestiti
      /*  Prestito p1 = new Prestito(uFind1, lP1, LocalDate.now(), null);
        Prestito p2 = new Prestito(uFind2, lP2, LocalDate.of(2024, 10, 8), null);*/


      /*  prestitoDAO.savePrestito(p1);
        prestitoDAO.savePrestito(p2);
        prestitoDAO.savePrestito(p3);
        prestitoDAO.savePrestito(p4);
        prestitoDAO.savePrestito(p5);*/


        em.close();
        emf.close();


    }
}
