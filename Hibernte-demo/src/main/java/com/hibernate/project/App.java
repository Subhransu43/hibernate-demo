package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        //Create session
        Session session = factory.getCurrentSession();
        
        try {
        	//Createing student object
        	Student student = new Student("Subhransu", "Bhandari", "subhransu.bhandari@outlook.com");
        	System.out.println(student.toString());
        	
        	//Start Transction
        	session.beginTransaction();
        	
        	//Save student object
        	session.save(student);
        	
        	//Commit Tracsction
        	session.getTransaction().commit();
        	
        } finally {
        	factory.close();
        }
    }
}
