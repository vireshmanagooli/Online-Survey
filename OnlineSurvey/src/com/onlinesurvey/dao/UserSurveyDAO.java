/**
 * 
 */
package com.onlinesurvey.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.onlinesurvey.bean.UserSurveyBean;

/**
 * @author Viresh
 *
 */
public class UserSurveyDAO {

	/**
	 * Retrive all the User Survey
	 * @return
	 */
	public List<UserSurveyBean> getAllSurvey(){
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();		
		
		Query queryResult = ss.createQuery("from com.onlinesurvey.bean.UserSurveyBean");  
		    
		List<UserSurveyBean> allSurvey = queryResult.list();  		  
		
		ss.getTransaction().commit();
		ss.close();
		
		return allSurvey;
	}
	
	/**
	 * Get survey for the users
	 * @param customerEmail
	 * @return
	 */
	public UserSurveyBean getSurveyForAUser(String customerEmail){
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();		
		
		Query queryResult = ss.createQuery("from com.onlinesurvey.bean.UserSurveyBean WHERE CustomerEmail = '"+customerEmail+"' AND UserResponse = 'N'");  
		    
		List<UserSurveyBean> allSurvey = queryResult.list();  		  
		
		ss.getTransaction().commit();
		ss.close();
		
		if(allSurvey.size() > 0)
			return allSurvey.get(0);
		
		return null;
	}
	
	/**
	 * Add the userSurveyBean to the database
	 * @param surveyBean
	 * @return
	 */
	public Long addSurvey(UserSurveyBean userSurveyBean){
		Long returnId = null;
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();		
		
		returnId = (Long)ss.save(userSurveyBean);
		
		ss.getTransaction().commit();
		ss.close();
		
		return returnId;
	}
	
	/**
	 * Update the userSurvey Row
	 * @param userSurveyBean
	 */
	public void updateuserSurvey(UserSurveyBean userSurveyBean){
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();	
				
	 	ss.update(userSurveyBean);
	 
	 	ss.getTransaction().commit();
		ss.close();
	}
}
