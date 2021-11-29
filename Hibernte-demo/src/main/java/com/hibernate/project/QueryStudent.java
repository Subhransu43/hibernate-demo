package com.hibernate.project;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

/**
 * Hello world!
 *
 */
public class QueryStudent 
{
    public static void main( String[] args )
    {
    	//Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        //Create session
        Session session = factory.getCurrentSession();
        
        try {
        	//Start a transaction
        	session.beginTransaction();
        	
        	//Query student
        	List<Student> allStudent = session.createQuery("from Student").getResultList();
        	
        	//Print all student
        	for(Student tempStudent : allStudent) {
        		System.out.println(tempStudent);
        	}
        	
        	//Commit Transaction
        	session.getTransaction().commit();
        	
        } finally {
        	factory.close();
        }
    }
}
