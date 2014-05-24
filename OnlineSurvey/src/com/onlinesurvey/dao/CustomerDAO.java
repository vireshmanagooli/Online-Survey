/**
 * 
 */
package com.onlinesurvey.dao;

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

	public int addCustomer(CustomerBean custBean){
		
		int returnId = 1;
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();
		ss.save(custBean);		
		ss.getTransaction().commit();
		ss.close();
		
		return returnId;
	}
}
