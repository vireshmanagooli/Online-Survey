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

import com.onlinesurvey.bean.SurveyBean;

/**
 * @author Viresh
 *
 */
public class SurveyDAO {

	/**
	 * Retrive all the Survey
	 * @return
	 */
	public List<SurveyBean> getAllSurvey(){
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();		
		
		Query queryResult = ss.createQuery("from com.onlinesurvey.bean.SurveyBean");  
		    
		List<SurveyBean> allSurvey = queryResult.list();  		  
		
		ss.getTransaction().commit();
		ss.close();
		
		return allSurvey;
	}
	
	/**
	 * Add the survey to the database
	 * @param surveyBean
	 * @return
	 */
	public Long addSurvey(SurveyBean surveyBean){
		Long returnId = null;
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();		
		
		returnId = (Long)ss.save(surveyBean);
		
		ss.getTransaction().commit();
		ss.close();
		
		return returnId;
	}
	
	/**
	 * Delete the Survey from the database
	 * @param surveyId
	 */
	public void deleteSurvey(Long surveyId){
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();	
		
		SurveyBean survey = 
                (SurveyBean)ss.get(SurveyBean.class, surveyId); 
		ss.delete(survey); 
		
		ss.getTransaction().commit();
		ss.close();
				
	}
}
