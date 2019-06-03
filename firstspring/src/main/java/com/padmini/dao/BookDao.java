package com.padmini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.padmini.configuration.JPAUtility;
import com.padmini.model.BookInfo;
import com.padmini.model.UserInfo;

@Service
public class BookDao {
	
	private static final String PERSISTENCE_UNIT_NAME = "user";
	
	public List<BookInfo> getAllBooks(String name)
	{
		
		EntityManager em = JPAUtility.getEntityManager(PERSISTENCE_UNIT_NAME);
	    em.getTransaction().begin();    
	    Query q = em.createQuery("Select b from BookInfo b where b.username=:arg ");
	    q.setParameter("arg", name);
	    List<BookInfo> books = q.getResultList();
	    em.getTransaction().commit();
	    em.close();
	    JPAUtility.close();
	    return books;
		
	}

}
