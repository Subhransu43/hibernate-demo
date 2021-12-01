package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			
			Student tempStudent = session.get(Student.class, 2);
			
			session.delete(tempStudent);
			
			//Another way
			session.createQuery("delete from Student where id=3").executeUpdate();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
