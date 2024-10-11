package Diana_Friptuleac;

import Diana_Friptuleac.classi.Libri;
import Diana_Friptuleac.classi.Riviste;
import Diana_Friptuleac.dao.CatalogoDAO;
import Diana_Friptuleac.enums.GenereLibri;
import Diana_Friptuleac.enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        //DAO
        CatalogoDAO catalogoDAO = new CatalogoDAO(em);

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


        em.close();
        emf.close();


    }
}
