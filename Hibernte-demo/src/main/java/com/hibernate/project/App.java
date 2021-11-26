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
        	/*Student student = new Student("Daffy", "Duck", "daffy.duck@outlook.com");
        	System.out.println(student.toString());
        	
        	//Start Transction
        	session.beginTransaction();
        	
        	//Save student object
        	session.save(student);
        	
        	//Commit Tracsction
        	session.getTransaction().commit();
        	*/
        	//Reading data drom DB
        	
        	//System.out.println("Fetching data for ID: "+student.getId());
        	
        	session = factory.getCurrentSession();
        	session.beginTransaction();
        	
        	Student stu = session.get(Student.class, 3);
        	System.out.println("Data : "+stu.toString());
        	
        	session.getTransaction().commit();
        	
        } finally {
        	factory.close();
        }
    }
}
