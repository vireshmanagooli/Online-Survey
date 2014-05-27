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

import com.onlinesurvey.bean.CustomerBean;
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
			
		UserSurveyBean mySurveyBean = (UserSurveyBean)ss.get(UserSurveyBean.class, userSurveyBean.getUserSurveyId()); 
				
		mySurveyBean.setUserResponse("Y");
		mySurveyBean.setSurveyId(userSurveyBean.getSurveyId());
		mySurveyBean.setQuestion_1(userSurveyBean.getQuestion_1());
		mySurveyBean.setQuestion_2(userSurveyBean.getQuestion_2());
		mySurveyBean.setQuestion_3(userSurveyBean.getQuestion_3());
		mySurveyBean.setQuestion_4(userSurveyBean.getQuestion_4());
		mySurveyBean.setQuestion_5(userSurveyBean.getQuestion_5());
		mySurveyBean.setQuestion_6(userSurveyBean.getQuestion_6());
		mySurveyBean.setQuestion_7(userSurveyBean.getQuestion_7());
		mySurveyBean.setQuestion_8(userSurveyBean.getQuestion_8());
		mySurveyBean.setQuestion_9(userSurveyBean.getQuestion_9());
		mySurveyBean.setQuestion_10(userSurveyBean.getQuestion_10());
	 	
		ss.update(mySurveyBean);
	 
	 	ss.getTransaction().commit();
		ss.close();
	}
}
