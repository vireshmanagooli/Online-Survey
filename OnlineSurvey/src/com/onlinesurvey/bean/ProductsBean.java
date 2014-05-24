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
@Entity(name = "product_table")
public class ProductsBean {

	@Id @GeneratedValue	
	private Long ProductId;
	
	@Column(name="ProductName")
	private String ProductName;
	
	@Column(name="ProductDesc")
	private String ProductDesc;
	
	@Column(name="ProductType")
	private String ProductType;
	
	@Column(name="Price")
	private int Price;
	
	@Column(name="MarketStatus")
	private String MarketStatus;
	
	@Column(name="LaunchYear")
	private String LaunchYear;

	public Long getProductId() {
		return ProductId;
	}

	public void setProductId(Long productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getProductDesc() {
		return ProductDesc;
	}

	public void setProductDesc(String productDesc) {
		ProductDesc = productDesc;
	}

	public String getProductType() {
		return ProductType;
	}

	public void setProductType(String productType) {
		ProductType = productType;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getMarketStatus() {
		return MarketStatus;
	}

	public void setMarketStatus(String marketStatus) {
		MarketStatus = marketStatus;
	}

	public String getLaunchYear() {
		return LaunchYear;
	}

	public void setLaunchYear(String launchYear) {
		LaunchYear = launchYear;
	}
		
}
