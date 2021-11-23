package ch.bbw.aal.buchladen.persistence;

import ch.bbw.aal.buchladen.model.Autor;
import ch.bbw.aal.buchladen.model.Buch;

import javax.persistence.EntityManager;
import java.util.List;

public class AutorPersistence {
    private static EntityManager entityManager;
    private static BuchPersistence buchPersistence = new BuchPersistence(entityManager);

    public AutorPersistence(EntityManager entityManager) {
        AutorPersistence.entityManager = entityManager;
    }

    public List<Autor> getAllAutors() {
        List autors = null;

        try {
            entityManager.getTransaction().begin();
            autors = entityManager.createNamedQuery("Autor.findAll").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return autors;
    }

    public void createAutor(Autor autor) {
        entityManager.getTransaction().begin();
        entityManager.persist( autor );
        entityManager.getTransaction( ).commit( );
    }

    public Autor findAutorWithId(int id) {
        return entityManager.find(Autor.class, id);
    }

    public void updateAutor(Autor autor) {
        entityManager.getTransaction().begin();
        entityManager.merge(autor);
        entityManager.getTransaction().commit();
    }

    public void deleteAutorWithId(int id) {
        entityManager.getTransaction().begin();
        BuchPersistence.allBookByAutor(buchPersistence.getAllBooks(), id).forEach(buch -> {
            if(buch != null){
                buchPersistence.deleteBookWithId(buch.getBuchId());
            }


        });
        Autor autor = entityManager.find(Autor.class, id);
        entityManager.remove(autor);
        entityManager.getTransaction().commit();
    }
}
