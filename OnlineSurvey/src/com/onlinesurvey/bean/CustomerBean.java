/**
 * 
 */
package com.onlinesurvey.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Viresh
 *
 */
@Entity(name = "customer_table")
public class CustomerBean {

	@Id @GeneratedValue
	private int CustomerId;
  
	@Column(name="CustomerName")
	private String CustomerName;

	@Column(name="CustomerDesc")
	private String CustomerDesc;

	@Column(name="CustomerAge")
	private int CustomerAge;
	
	@Column(name="CustomerEmail")
	private String CustomerEmail;               

	@Column(name="CustomerCell")
	private String CustomerCell;

	@Column(name="CustomerDL")
	private String CustomerDL;
	
	@Column(name="CustomerPwd")
	private String CustomerPwd;

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerDesc() {
		return CustomerDesc;
	}

	public void setCustomerDesc(String customerDesc) {
		CustomerDesc = customerDesc;
	}

	public int getCustomerAge() {
		return CustomerAge;
	}

	public void setCustomerAge(int customerAge) {
		CustomerAge = customerAge;
	}

	public String getCustomerEmail() {
		return CustomerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}

	public String getCustomerCell() {
		return CustomerCell;
	}

	public void setCustomerCell(String customerCell) {
		CustomerCell = customerCell;
	}

	public String getCustomerDL() {
		return CustomerDL;
	}

	public void setCustomerDL(String customerDL) {
		CustomerDL = customerDL;
	}

	public String getCustomerPwd() {
		return CustomerPwd;
	}

	public void setCustomerPwd(String customerPwd) {
		CustomerPwd = customerPwd;
	}
		
}
