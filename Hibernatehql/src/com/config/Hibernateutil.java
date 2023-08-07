package com.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.MySQLDialect;


import com.model.Student;







public class Hibernateutil {
	private static 	StandardServiceRegistry registry;
	private static SessionFactory sf=null;
	public static SessionFactory getSessionFactory()		
		{
			if(sf==null) {
				try {

					//connection mapping commands
					Map<String, String> map=new HashMap<>();
					map.put(Environment.DRIVER,"com.mysql.jdbc.Driver" );
					map.put(Environment.URL,"jdbc:mysql://localhost:3306/studenthql");
					map.put(Environment.USER,"root" );
					map.put(Environment.PASS,"root");
					
					//hibernate mappoing
					map.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect" );
					map.put(Environment.HBM2DDL_AUTO,"update" );
					map.put(Environment.SHOW_SQL, "true");
					
					//create object of StandardServiceRegistry
				 registry = new  StandardServiceRegistryBuilder().applySettings(map).build();
				 
				 //create object of metadatasource
				 
				 MetadataSources mds= new MetadataSources(registry);
				 //map entity class
				 mds.addAnnotatedClass(Student.class);
				
				 //create object of metadata
				 Metadata md= mds.getMetadataBuilder().build();
				  
				 sf=md.getSessionFactoryBuilder().build();
			
					
				
				} catch(Exception e) {
					System.out.println("SessionFactory creation fails" +e);
				}
		}
			return sf;
	}

}

