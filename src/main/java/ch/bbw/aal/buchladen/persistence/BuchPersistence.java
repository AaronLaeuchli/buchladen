package ch.bbw.aal.buchladen.persistence;

import ch.bbw.aal.buchladen.model.Autor;
import ch.bbw.aal.buchladen.model.Buch;

import javax.persistence.EntityManager;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class BuchPersistence {
    private static EntityManager entityManager;

    public BuchPersistence(EntityManager entityManager) {
        BuchPersistence.entityManager = entityManager;
    }

    public List<Buch> getAllBooks() {
        List books = null;

        try {
            entityManager.getTransaction().begin();
            books = entityManager.createNamedQuery("Buch.findAll").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return books;
    }

    public void createBook(Buch book) {
        entityManager.getTransaction().begin();
        entityManager.persist( book );
        entityManager.getTransaction( ).commit( );
    }

    public Buch findBookWithId(int id) {
        return entityManager.find(Buch.class, id);
    }

    public void updateBook(Buch book) {
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.getTransaction().commit();
    }

    public void deleteBookWithId(int id) {
        entityManager.getTransaction().begin();
        Buch book = entityManager.find(Buch.class, id);
        entityManager.remove(book);
        entityManager.getTransaction().commit();
    }

    public static List<Buch> allBookByAutor(List<Buch> books,int autorid){
        List<Buch> returnBuchList = new ArrayList<>();
        for (Buch buch: books
             ) {
            if (buch.getAutor().getAutorId() == autorid) {
                returnBuchList.add(buch);
            }
        }
        return returnBuchList;

    }
}
