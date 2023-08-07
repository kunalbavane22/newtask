package com.client;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.Hibernateutil;
import com.model.Student;

public class Test {
	public static void main(String[] args) {
		
		SessionFactory sf=Hibernateutil.getSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		String sql ="insert into student values(?,?)";
		SQLQuery<Student> query=session.createSQLQuery(sql);
		  
		//cooment
		
	}

}
