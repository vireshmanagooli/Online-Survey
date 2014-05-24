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

import com.onlinesurvey.bean.ProductsBean;

/**
 * @author Viresh
 *
 */
public class ProductsDAO {
	
	/**
	 * Add the products to the database
	 * @param productsBean
	 * @return
	 */
	public Long addProduct(ProductsBean productsBean){
		Long returnId = null;
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();		
		
		returnId = (Long)ss.save(productsBean);
		
		ss.getTransaction().commit();
		ss.close();
		
		return returnId;
	}
	
	/**
	 * Get all the products from the database
	 * @return
	 */
	public List<ProductsBean> getAllProducts(){
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();		
		
		Query queryResult = ss.createQuery("from com.onlinesurvey.bean.ProductsBean");  
		    
		List<ProductsBean> allProducts = queryResult.list();  		  
		
		ss.getTransaction().commit();
		ss.close();
		
		return allProducts;
	}

	/**
	 * Delete the product from the database
	 * @param productId
	 */
	public void deleteProduct(Long productId){
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();	
		
		ProductsBean product = 
                (ProductsBean)ss.get(ProductsBean.class, productId); 
		ss.delete(product); 
		
		ss.getTransaction().commit();
		ss.close();
				
	}
	
	/**
	 * Update the product
	 * @param prodBean
	 */
	public void updateProduct(ProductsBean prodBean){
		
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session ss=sf.openSession();
		ss.beginTransaction();	
				
	 	ss.update(prodBean);
	 
	 	ss.getTransaction().commit();
		ss.close();
	}
}
