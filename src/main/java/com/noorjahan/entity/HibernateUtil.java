package com.noorjahan.entity;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			Configuration con = new Configuration();
			Properties pro = new Properties();
			pro.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver" );
			pro.put(Environment.URL, "jdbc:mysql://localhost:3306/youtube");
			pro.put(Environment.USER, "root");
			pro.put(Environment.PASS, "root");
			pro.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			pro.put(Environment.HBM2DDL_AUTO, "update");
			pro.put(Environment.SHOW_SQL, true);
			pro.put(Environment.FORMAT_SQL, "true");
			con.setProperties(pro);
			ServiceRegistry ser= new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
			con.addAnnotatedClass(Emp.class);
		//	con.addAnnotatedClass(Address.class);
			sessionFactory= con.buildSessionFactory(ser);
			
		}
         return sessionFactory;
         
	}
	
}
