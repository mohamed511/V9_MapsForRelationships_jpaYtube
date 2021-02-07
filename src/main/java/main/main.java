package main;

import entity.Event;
import entity.Price;
import entity.Product;
import entity.enums.Currency;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        // define Entity Manager
        // create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        //create entity manager
        EntityManager em = emf.createEntityManager();

        try{
            // get transaction
            em.getTransaction().begin();
            System.out.println("==========> ");
            Price p = new Price();
            p.setAmount(100);
            p.setCurrency(Currency.EUR);
            em.persist(p);
            em.getTransaction().commit();
            em.close();
        }catch (Exception e){
            em.getTransaction().rollback();
            em.close();
        }

    }
}
