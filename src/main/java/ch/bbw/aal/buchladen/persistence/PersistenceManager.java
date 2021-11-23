package ch.bbw.aal.buchladen.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class: PersistenceManager
 *
 * @author Aaron Läuchli
 * @version 16.11.2021
 */

public class PersistenceManager {
    private static EntityManagerFactory emfactory;
    private static EntityManager entityManager;
    private static AutorPersistence autorPersistence;
    private static BuchPersistence buchPersistence;

    EntityManagerFa

    public void close(){
        entityManager.close();
        emfactory.close();
    }

    public static AutorPersistence getAutorPersistence() {
        if (autorPersistence == null) {
            if (entityManager == null) {
                emfactory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
                entityManager = emfactory.createEntityManager();
            }
            autorPersistence = new AutorPersistence(entityManager);
        }
        return autorPersistence;
    }

    public static BuchPersistence getBuchPersistence() {
        if (buchPersistence == null) {
            if (entityManager == null) {
                emfactory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
                entityManager = emfactory.createEntityManager();
            }
            buchPersistence = new BuchPersistence(entityManager);
        }
        return buchPersistence;
    }
}
