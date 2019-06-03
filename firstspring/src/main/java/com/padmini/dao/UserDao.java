package com.padmini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.padmini.configuration.JPAUtility;
import com.padmini.model.UserInfo;

@Service
public class UserDao {
	
	private static final String PERSISTENCE_UNIT_NAME = "user";
	
	public List<UserInfo> getAllUsers(UserInfo user)
	{
		
		//System.out.println("In getAllUsers "+ user.getUname());
		UserInfo u = null;
		//System.out.println("In Dao "+ user.getUname());
		EntityManager em = JPAUtility.getEntityManager(PERSISTENCE_UNIT_NAME);
	    em.getTransaction().begin();    
	    Query q = em.createQuery("Select u from UserInfo u ");
	    List<UserInfo> users = q.getResultList();
	    em.getTransaction().commit();
	    em.close();
	    JPAUtility.close();
	    return users;
	}

	public Boolean getUser(UserInfo user)
	{
		
		System.out.println("In getUser "+ user.getUname());
		EntityManager em = JPAUtility.getEntityManager(PERSISTENCE_UNIT_NAME);
	    em.getTransaction().begin();    
	    Query q = em.createQuery("Select u from UserInfo u where u.uname=:arg1");
	    q.setParameter("arg1", user.getUname());    
	    try {
	      UserInfo ul= (UserInfo) q.getSingleResult();
	      System.out.println("username :"+ul.getUname()+ " Password : "+ul.getPassword());
	      em.getTransaction().commit();
	    em.close();
	    JPAUtility.close();
	    if(ul.getUname().equals(user.getUname()) && ul.getPassword().equals(user.getPassword()))
		return true;
	    else	     
	    	return false;	    	
	    }
	    catch(Exception e)
	    {	    	
	    	e.printStackTrace();
	    	return false;
	    }		
	}
	
	public String signUp(UserInfo user)
	{
		
		EntityManager em = JPAUtility.getEntityManager(PERSISTENCE_UNIT_NAME);
	    em.getTransaction().begin();
	   
	    Query q = em.createQuery("Select u from UserInfo u where u.uname=:arg1");
	    q.setParameter("arg1", user.getUname());  
	    try
	    {	    	
	    	List<UserInfo> ul = q.getResultList();
	    	 em.getTransaction().commit();
	 	    em.close();
	    	if(ul.size()>0) {
	    		System.out.println(" user exists");
	    		return null;
	    	}
	    	else {
	        em = JPAUtility.getEntityManager(PERSISTENCE_UNIT_NAME);
	    	em.getTransaction().begin();
	    	em.persist(user);
	    	em.getTransaction().commit();
	    	em.close();
	    	JPAUtility.close();
	    	
	    	return user.getUname();
	    	}
	    	
	    }
	    
	    catch(Exception e){	    	
	    	e.printStackTrace();	    	
	    }
		return null;
		
	}
	
}
