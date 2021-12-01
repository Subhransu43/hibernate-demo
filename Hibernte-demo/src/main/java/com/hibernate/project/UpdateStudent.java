package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

public class UpdateStudent {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 2;
			
			session.beginTransaction();
			
			System.out.println("Fetching Student with ID :"+studentId);
			
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("Student fetched :"+tempStudent);
			
			tempStudent.setFirstName("Avinandan");
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
