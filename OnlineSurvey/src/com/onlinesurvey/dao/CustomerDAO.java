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

/**
 * @author Viresh
 *
 */
public class CustomerDAO {

	/**
	 * Method to add the customer to the database
	 * @param custBean
	 * @return
	 */
	public Long addCustomer(CustomerBean custBean){
		
		Long returnId;
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();		
		returnId = (Long)ss.save(custBean);
		ss.getTransaction().commit();
		ss.close();
		
		return returnId;
	}
	
	/**
	 * Retrieve all the customers details
	 * @return
	 */
	public List<CustomerBean> getAllCustomer(){
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();		
		
		Query queryResult = ss.createQuery("from com.onlinesurvey.bean.CustomerBean");  
		    
		List<CustomerBean> allCustomers = queryResult.list();  		  
		
		ss.getTransaction().commit();
		ss.close();
		
		return allCustomers;
	}
	
	/**
	 * Delete the customer details
	 * @param customerId
	 */
	public void deleteCustomer(Long customerId){
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();	
		
		CustomerBean customer = 
                (CustomerBean)ss.get(CustomerBean.class, customerId); 
		ss.delete(customer); 
		
		ss.getTransaction().commit();
		ss.close();
				
	}
	
	/**
	 * Update the Customer Row
	 * @param custBean
	 */
	public void updateCustomer(CustomerBean custBean){
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();	
				
	 	ss.update(custBean);
	 
	 	ss.getTransaction().commit();
		ss.close();
	}
}
