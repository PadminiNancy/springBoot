package com.padmini.configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class JPAUtility {
 	private static EntityManagerFactory emFactory =null;
	public static EntityManager getEntityManager(String persistenceUnit){
		emFactory = Persistence.createEntityManagerFactory(persistenceUnit);
		return emFactory.createEntityManager();
	}
	public static void close(){
		emFactory.close();
	}
} 
