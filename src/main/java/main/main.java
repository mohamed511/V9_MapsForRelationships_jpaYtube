package main;


import entity.Department;
import entity.DepartmentDetail;
import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        // define Entity Manager
        // create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        //create entity manager
        EntityManager em = emf.createEntityManager();

        try {
            // get transaction
            em.getTransaction().begin();
            System.out.println("Start...");
            Department department = new Department("I_T");
            DepartmentDetail dd = new DepartmentDetail("C2", department);
            Employee employee = new Employee("emp1", dd);
            Employee employee2 = new Employee("emp2", dd);
            em.persist(department);
            em.persist(employee);
            em.persist(employee2);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        }
    }
}
