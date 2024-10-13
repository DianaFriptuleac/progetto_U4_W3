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


      /*  catalogoDAO.saveElement(l1);
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

       /* catalogoDAO.saveElement(r1);
        catalogoDAO.saveElement(r2);
        catalogoDAO.saveElement(r3);
        catalogoDAO.saveElement(r4);
        catalogoDAO.saveElement(r5);*/


        //********************************* 2.Rimozione di un elemento del catalogo dato un codice ISBN ********
        //   catalogoDAO.deleteElement(UUID.fromString("fa7c6490-8b10-472b-8b1d-e04289957245"));


        //********************************** 3.Ricerca per ISBN ******************************
        Catalogo elementById1 = catalogoDAO.findById("c76049a8-4932-4206-8451-dfd04471ae21");
        Catalogo elementById2 = catalogoDAO.findById("c58416a3-bd77-4f49-812f-f2c451d0d89d");
        //  System.out.println("Elemento trovato: " + elementById1);
        //  System.out.println("Elemento trovato: " + elementById2);  */


        //********************************** 4.Ricerca per anno pubblicazione ******************************
    /*    List<Catalogo> elementByYear1 = catalogoDAO.findByYear(2024);
        List<Catalogo> elementByYear2 = catalogoDAO.findByYear(1954);
        System.out.println("******************* Elementi trovati per l'anno 2024: ******************");
        for (Catalogo catalogo : elementByYear1) {
            System.out.println(catalogo);
        }
        System.out.println();

        System.out.println("******************** Elementi trovati per l'anno 1954: *******************");
        for (Catalogo catalogo : elementByYear2) {
            System.out.println(catalogo);
        }
        System.out.println(); */

        //********************************** 5.Ricerca per autore ******************************
      /*  List<Libri> libriPerAutore = catalogoDAO.findByAutore("Umberto Eco");
        System.out.println("******************** Libri scritti da Umberto Eco: *******************");
        for (Libri libro : libriPerAutore) {
            System.out.println(libro);
        }

        System.out.println(); */

        //********************************** 6.Ricerca per titolo o parte di esso ***********************
    /*    List<Catalogo> elemntoPerTitolo = catalogoDAO.findByTitle("Forbes");
        System.out.println("******************** Elemento con il titolo Forbes: *******************");
        System.out.println(elemntoPerTitolo); */

        //***************************************************************************************************

        //----------- Savo utenti
        Utente u1 = new Utente("Anna", "Margini", LocalDate.of(19886, 5, 24));
        Utente u2 = new Utente("Luca", "Biagi", LocalDate.of(1984, 3, 28));
        Utente u3 = new Utente("Marina", "Voli", LocalDate.of(1995, 8, 30));


       /* utenteDAO.saveUtente(u1);
        utenteDAO.saveUtente(u2);
        utenteDAO.saveUtente(u3); */


        //Cerco utenti e articoli per id
        Utente uFind1 = utenteDAO.findById("39b7405b-acf8-4be8-91a0-7d4e9b2dd115");
        Catalogo r1F = catalogoDAO.findById("5b2bec7e-5c58-4fd8-94b7-daa6a2cf6dc0");
        Utente uFind2 = utenteDAO.findById("5c4589ec-31ec-4b01-b55b-e26681842484");
        Catalogo l1F = catalogoDAO.findById("139d77f5-2a79-4926-b60a-a26d7f9fd731");

     /*   System.out.println("Utente trovato 1: " + uFind1.getIdTessera() + " - " + uFind1.getCognome());
        System.out.println("Utente trovato 2: " + uFind2.getIdTessera() + " - " + uFind2.getCognome());
        System.out.println("Articolo trovato 1: " + r1F.getISBN() + " - " + r1F.getTitolo());
        System.out.println("Articolo trovato 2: " + l1F.getISBN() + " - " + l1F.getTitolo());

*/
        //Creao il prestito
        Prestito p1 = new Prestito(uFind1, r1F, LocalDate.now(), null);
        //   System.out.println("Prestito per utente ID: " + p1.getUtente());
        Prestito p2 = new Prestito(uFind2, l1F, LocalDate.of(2024, 10, 8), null);
        //   System.out.println("Prestito per utente ID: " + p2.getUtente());
        Prestito p3 = new Prestito(uFind1, elementById1, LocalDate.of(2024, 9, 8), null);
        //   System.out.println("Prestito per utente ID: " + p3.getUtente());

        // Salva i prestiti nel database
        // prestitoDAO.savePrestito(p1);
        // prestitoDAO.savePrestito(p2);
        // prestitoDAO.savePrestito(p3);  - prestito scaduto


        //***************************************************************************************************

        //******************** 7.Ricerca degli elementi attualmente in prestito dato un numero di tessera utente ***********************
      /*  List<Prestito> prestitiAttivi = prestitoDAO.findByPrestito(uFind1.getIdTessera());
        System.out.println("Prestiti attualmente in corso per gli utente: ");
        for (Prestito elemento : prestitiAttivi) {
            System.out.println(elemento);
        }
       */

        //******************** 8.Ricerca per prestiti scaduti ***********************
        List<Prestito> prestitiScaduti = prestitoDAO.findByPScaduto();
        System.out.println("Prestiti scaduti per: ");
        for (Prestito prestito : prestitiScaduti) {
            System.out.println(prestito);
        }

        em.close();
        emf.close();
    }
}
