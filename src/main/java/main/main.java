package main;

import entity.*;
import entity.embeddable.Address;
import entity.enums.Currency;
import entity.pk.DepartmentPk;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

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
            Department department = new Department();
            department.setName("B_2");
            department.setCode("B");
            department.setNumber(2);
            em.persist(department);
            em.getTransaction().commit();
            em.close();
        }catch (Exception e){
            em.getTransaction().rollback();
            em.close();
        }

    }
}
