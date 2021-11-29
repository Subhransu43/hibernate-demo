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
        	displayStudent(allStudent);
        	
        	//Query student with last name Bhandari
        	System.out.println("All student with lastName Bhandari :");
        	allStudent = session.createQuery("from Student s where s.lastName='Bhandari'").getResultList();

        	displayStudent(allStudent);
        	
        	//Using OR in HQL
        	System.out.println("All Student with First name Daffy or Last name Bhandari");
        	allStudent = session.createQuery("from Student s where s.firstName='Daffy' OR s.lastName='Bhandari'").getResultList();
                    	
        	displayStudent(allStudent);
        	
        	//Using LIKE in HQL
        	System.out.println("All Student with Email like '@outlook.com'");
        	allStudent = session.createQuery("from Student s where s.email LIKE '%@outlook.com'").getResultList();
        	
        	displayStudent(allStudent);
        	
        	//Commit Transaction
        	session.getTransaction().commit();
        	
        } finally {
        	factory.close();
        }
    }

	private static void displayStudent(List<Student> allStudent) {
		for(Student tempStudent : allStudent) {
			System.out.println(tempStudent);
		}
	}
}
