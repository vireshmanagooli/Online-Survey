/**
 * 
 */
package com.onlinesurvey.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.onlinesurvey.bean.ProductsBean;
import com.onlinesurvey.dao.ProductsDAO;

/**
 * @author Viresh
 *
 */
@Path("/Products")
public class ProductsService {

	@Path("/GetProducts")
	@POST	
	@Produces(MediaType.APPLICATION_JSON) 
	public String getProducts(@QueryParam("jtStartIndex") int jtStartIndex,@QueryParam("jtPageSize") int jtPageSize, @QueryParam("jtSorting") String jtSorting,
			@QueryParam("callback") String callback) throws JSONException {
				
		JSONObject returnObject = new JSONObject();	
		JSONArray returnArray = new JSONArray();
		
		List<ProductsBean> allProducts = new ProductsDAO().getAllProducts();
		
		for (int i = 0; i < allProducts.size(); i++) {  
			ProductsBean productBean = (ProductsBean) allProducts.get(i);  
			JSONObject record = populateJSON(productBean);
			returnArray.put(record);
		} 		
					
		returnObject.put(ServiceConstants.RESULT, ServiceConstants.OK);
		returnObject.put(ServiceConstants.RECORDS,returnArray);
		
		System.out.println("GetProducts : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/AddProducts")
	@Produces(MediaType.APPLICATION_JSON) 
	public String addProducts(@Context HttpServletRequest request) throws JSONException {
	
		JSONObject returnObject = new JSONObject();
		String ProductName = request.getParameter("ProductName");
		String ProductDesc = request.getParameter("ProductDesc");
		String ProductType = request.getParameter("ProductType");
		String Price = request.getParameter("Price");
		String MarketStatus = request.getParameter("MarketStatus");
		String LaunchYear = request.getParameter("LaunchYear");		

		//Validation
		
				String ErrorMessage = null;
				boolean isValid = true;
				
				if(ProductName == null || ProductName.isEmpty()){
					isValid = false;
					ErrorMessage = "Product Name Can't be Empty \n";
				}else if(ProductDesc == null || ProductDesc.isEmpty()){
					isValid = false;
					ErrorMessage = "Product Desc Can't be Empty \n";
				}else if(ProductType == null || ProductType.isEmpty()){
					isValid = false;
					ErrorMessage = "Product Type Can't be Empty \n";
				}else if(Price == null || Price.isEmpty()){
					isValid = false;
					ErrorMessage = "Price Can't be Empty \n";
				}else if(!isIntegerParseInt(Price)){
					isValid = false;
					ErrorMessage = "Price Can only be Integer \n";
				}else if(MarketStatus == null || MarketStatus.isEmpty()){
					isValid = false;
					ErrorMessage = "Market Status Can't be Empty \n";
				}else if(LaunchYear == null || LaunchYear.isEmpty()){
					isValid = false;
					ErrorMessage = "Launch Year Can't be Empty \n";
				}
						
				//Check whether all the validations are passed
				if(isValid){
					//Populate the Bean Class then parsist into the database
					ProductsBean productsBean = new ProductsBean();
					productsBean.setLaunchYear(LaunchYear);
					productsBean.setMarketStatus(MarketStatus);
					productsBean.setPrice(Integer.parseInt(Price));
					productsBean.setProductDesc(ProductDesc);
					productsBean.setProductName(ProductName);
					productsBean.setProductType(ProductType);					
					
					Long ProductsId = new ProductsDAO().addProduct(productsBean);
					
					productsBean.setProductId(ProductsId);
					//populate the JSON object
					JSONObject record = populateJSON(productsBean);
					JSONArray returnArray = new JSONArray();
					
					returnArray.put(record);
					
					returnObject.put(ServiceConstants.RESULT, ServiceConstants.OK);
					returnObject.put(ServiceConstants.RECORDS,returnArray);
				}else{
					returnObject.put(ServiceConstants.RESULT, ServiceConstants.ERROR);
					returnObject.put(ServiceConstants.MESSAGE, ErrorMessage);
				}
		System.out.println(" : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/UpdateProducts")
	@Produces(MediaType.APPLICATION_JSON) 
	public String updateProducts(@Context HttpServletRequest request) throws JSONException {
	
		JSONObject returnObject = new JSONObject();
		String ProductName = request.getParameter("ProductName");
		String ProductDesc = request.getParameter("ProductDesc");
		String ProductType = request.getParameter("ProductType");
		String Price = request.getParameter("Price");
		String MarketStatus = request.getParameter("MarketStatus");
		String LaunchYear = request.getParameter("LaunchYear");	
		String ProductId = request.getParameter("ProductId");

		//Validation
		
				String ErrorMessage = null;
				boolean isValid = true;
				
				if(ProductName == null || ProductName.isEmpty()){
					isValid = false;
					ErrorMessage = "Product Name Can't be Empty \n";
				}else if(ProductDesc == null || ProductDesc.isEmpty()){
					isValid = false;
					ErrorMessage = "Product Desc Can't be Empty \n";
				}else if(ProductType == null || ProductType.isEmpty()){
					isValid = false;
					ErrorMessage = "Product Type Can't be Empty \n";
				}else if(Price == null || Price.isEmpty()){
					isValid = false;
					ErrorMessage = "Price Can't be Empty \n";
				}else if(!isIntegerParseInt(Price)){
					isValid = false;
					ErrorMessage = "Price Can only be Integer \n";
				}else if(MarketStatus == null || MarketStatus.isEmpty()){
					isValid = false;
					ErrorMessage = "Market Status Can't be Empty \n";
				}else if(LaunchYear == null || LaunchYear.isEmpty()){
					isValid = false;
					ErrorMessage = "Launch Year Can't be Empty \n";
				}
						
				//Check whether all the validations are passed
				if(isValid){
					//Populate the Bean Class then parsist into the database
					ProductsBean productsBean = new ProductsBean();
					productsBean.setLaunchYear(LaunchYear);
					productsBean.setMarketStatus(MarketStatus);
					productsBean.setPrice(Integer.parseInt(Price));
					productsBean.setProductDesc(ProductDesc);
					productsBean.setProductName(ProductName);
					productsBean.setProductType(ProductType);					
					productsBean.setProductId(Long.parseLong(ProductId));
					new ProductsDAO().updateProduct(productsBean);
										
					//populate the JSON object
					JSONObject record = populateJSON(productsBean);
					JSONArray returnArray = new JSONArray();
					
					returnArray.put(record);
					
					returnObject.put(ServiceConstants.RESULT, ServiceConstants.OK);
					returnObject.put(ServiceConstants.RECORDS,returnArray);
				}else{
					returnObject.put(ServiceConstants.RESULT, ServiceConstants.ERROR);
					returnObject.put(ServiceConstants.MESSAGE, ErrorMessage);
				}
		System.out.println(" : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/DeleteProducts")
	@Produces(MediaType.APPLICATION_JSON) 
	public String deleteProducts(@Context HttpServletRequest request) throws JSONException {
	
		String ProductId = request.getParameter("ProductId");
		Long prodId = Long.parseLong(ProductId);
		
		new ProductsDAO().deleteProduct(prodId);
		
		JSONObject returnObject = new JSONObject();
		returnObject.put(ServiceConstants.RESULT, ServiceConstants.OK);
		
		System.out.println("DeleteProducts : " + returnObject.toString());
		return returnObject.toString();
	}
	
	/**
	 * Check for the Integer
	 * @param str
	 * @return
	 */
	private boolean isIntegerParseInt(String str) {
	     try {
	           Integer.parseInt(str);
	            return true;
	        } catch (NumberFormatException nfe) {}
	        return false;
	}
	/**
	 * Method to populate the JSON object
	 * @param productsBean
	 * @return
	 * @throws JSONException
	 */
	private JSONObject populateJSON(ProductsBean productsBean) throws JSONException{

		JSONObject returnObj = new JSONObject();
		returnObj.put("ProductId",productsBean.getProductId());
		returnObj.put("ProductName",productsBean.getProductName());
		returnObj.put("ProductDesc",productsBean.getProductDesc());
		returnObj.put("ProductType",productsBean.getProductType());
		returnObj.put("Price",productsBean.getPrice());
		returnObj.put("MarketStatus",productsBean.getMarketStatus());
		returnObj.put("LaunchYear",productsBean.getLaunchYear());		
		
		return returnObj;
	}
}
