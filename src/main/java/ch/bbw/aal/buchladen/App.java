package ch.bbw.aal.buchladen;

import ch.bbw.aal.buchladen.model.Autor;
import ch.bbw.aal.buchladen.model.Buch;
import ch.bbw.aal.buchladen.persistence.AutorPersistence;
import ch.bbw.aal.buchladen.persistence.BuchPersistence;
import ch.bbw.aal.buchladen.persistence.PersistenceManager;

import java.util.List;

/**
 * Class: App
 *
 * @author Aaron Läuchli
 * @version 16.11.2021
 */

public class App {
        public static PersistenceManager persistenceManager = new PersistenceManager();
        public static AutorPersistence autorPersistence = PersistenceManager.getAutorPersistence();
        public static BuchPersistence buchPersistence = PersistenceManager.getBuchPersistence();
    public static void main(String[] args) {
        List<Autor> AutorList;
        List<Buch> BookList;

        //Create
        Autor autor1 = new Autor(1, "Aaron", "Läuchli");
        Autor autor2 = new Autor(2, "Lindon", "Läuchli");
        autorPersistence.createAutor(autor1);
        autorPersistence.createAutor(autor2);

        System.out.println("List Autors:");
        AutorList = autorPersistence.getAllAutors();
        printAutorList(AutorList);

        //Update
        autor2.setVorname("Test");
        autorPersistence.updateAutor(autor2);

        System.out.println("List Autors:");
        AutorList = autorPersistence.getAllAutors();
        printAutorList(AutorList);

        //Delete Autor
        autorPersistence.deleteAutorWithId(2);
        System.out.println("List Autors:");
        AutorList = autorPersistence.getAllAutors();
        printAutorList(AutorList);

/**

        //Create Buch
        Buch HerrDerRinge = new Buch(2, "Herr der Ringe", 690, autorPersistence.findAutorWithId(1));
        buchPersistence.createBook(HerrDerRinge);

        System.out.println("List Books:");
        BookList = buchPersistence.getAllBooks();
        printBuchList(BookList);

        //Update
        HerrDerRinge.setBuchTitel("Test");
        buchPersistence.updateBook(HerrDerRinge);

        System.out.println("List Books:");
        BookList = buchPersistence.getAllBooks();
        printBuchList(BookList);



        //Delete
        buchPersistence.deleteBookWithId(2);

        System.out.println("List Books:");
        BookList = buchPersistence.getAllBooks();
        printBuchList(BookList);

 */

        persistenceManager.close();


    }

    private static void printAutorList(List<Autor> autors) {
        for (Autor autor : autors) {
            System.out.println(autor.toString());
        }
        System.out.println("\n------------------------------------\n");
    }

    private static void printBuchList(List<Buch> books) {
        for (Buch buch : books) {
            System.out.println("Id: " + buch.getBuchId()+ "\n Titel: " + buch.getBuchTitel()+ "\n Autor: " + buch.getAutor().getVorname());
        }
        System.out.println("\n------------------------------------\n");
    }
}
