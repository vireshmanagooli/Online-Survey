/**
 * 
 */
package com.onlinesurvey.service;

import javax.servlet.ServletContext;
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

import com.onlinesurvey.bean.CustomerBean;
import com.onlinesurvey.dao.CustomerDAO;

/**
 * @author Viresh
 *
 */
@Path("/Customer")
public class CustomerService {

	@Context
	private ServletContext context;
	
	@Path("/GetCustomers")
	@POST	
	@Produces(MediaType.APPLICATION_JSON) 
	public String getProducts(@QueryParam("jtStartIndex") int jtStartIndex,@QueryParam("jtPageSize") int jtPageSize, @QueryParam("jtSorting") String jtSorting,
			@QueryParam("callback") String callback) throws JSONException {
				
		JSONObject returnObject = new JSONObject();	
		JSONArray returnArray = new JSONArray();
		
		JSONObject tableObject = new JSONObject();
		tableObject.put(ServiceConstants.PRODUCT_ID, 1);
		tableObject.put(ServiceConstants.PRODUCT_NAME, "Samsung Mobile");
		tableObject.put(ServiceConstants.PRODUCT_DESC, "Smart Phone");
		tableObject.put(ServiceConstants.PRODUCT_TYPE, "Cell Phone");
		tableObject.put(ServiceConstants.PRICE, 20000);
		tableObject.put(ServiceConstants.MARKET_STATUS, "Positive");
		tableObject.put(ServiceConstants.LAUNCH_YEAR, "Date(1320259705710)");
		returnArray.put(tableObject);
		
		tableObject = new JSONObject();
		tableObject.put(ServiceConstants.PRODUCT_ID, 2);
		tableObject.put(ServiceConstants.PRODUCT_NAME, "Sony Mobile");
		tableObject.put(ServiceConstants.PRODUCT_DESC, "Smart Phone");
		tableObject.put(ServiceConstants.PRODUCT_TYPE, "Cell Phone");
		tableObject.put(ServiceConstants.PRICE, 24000);
		tableObject.put(ServiceConstants.MARKET_STATUS, "Positive");
		tableObject.put(ServiceConstants.LAUNCH_YEAR, "Date(1320259705710)");
		returnArray.put(tableObject);		
					
		returnObject.put(ServiceConstants.RESULT, ServiceConstants.OK);
		returnObject.put(ServiceConstants.RECORDS,returnArray);
		
		System.out.println("GetProducts : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/AddCustomers")
	@Produces(MediaType.APPLICATION_JSON) 
	public String addProducts(@Context HttpServletRequest request) throws JSONException {			
		
		JSONObject returnObject = new JSONObject();
		String CustomerName = request.getParameter("CustomerName");
		String CustomerDesc = request.getParameter("CustomerDesc");
		String CustomerAge = request.getParameter("CustomerAge");
		String CustomerEmail = request.getParameter("CustomerEmail");
		String CustomerCell = request.getParameter("CustomerCell");
		String CustomerDL = request.getParameter("CustomerDL");
		String CustomerPwd = request.getParameter("CustomerPwd");
		
		//Validation
		
		String ErrorMessage = null;
		boolean isValid = true;
		
		if(CustomerName == null || CustomerName.isEmpty()){
			isValid = false;
			ErrorMessage = "Customer Name Can't be Empty \n";
		}else if(CustomerDesc == null || CustomerDesc.isEmpty()){
			isValid = false;
			ErrorMessage = "Customer Desc Can't be Empty \n";
		}else if(CustomerAge == null || CustomerAge.isEmpty()){
			isValid = false;
			ErrorMessage = "Customer Age Can't be Empty \n";
		}else if(!isIntegerParseInt(CustomerAge)){
			isValid = false;
			ErrorMessage = "Customer Age Can only be Integer \n";
		}else if(CustomerEmail == null || CustomerEmail.isEmpty()){
			isValid = false;
			ErrorMessage = "Customer Email Can't be Empty \n";
		}else if(!isEmailValid(CustomerEmail)){
			isValid = false;
			ErrorMessage = "Email Address is not valid \n";
		}else if(CustomerCell == null || CustomerCell.isEmpty()){
			isValid = false;
			ErrorMessage = "Customer Cell Can't be Empty \n";
		}else if(!isIntegerParseInt(CustomerCell)){
			isValid = false;
			ErrorMessage = "Customer Cell No Can only be Integer \n";
		}else if(CustomerDL == null || CustomerDL.isEmpty()){
			isValid = false;
			ErrorMessage = "Customer DL Can't be Empty \n";
		}else if(!isValidEmailDL(CustomerDL)){
			isValid = false;
			ErrorMessage = "Customer DL Can only be 'North' or 'South' or 'East' or 'West' \n";
		}else if(CustomerPwd == null || CustomerPwd.isEmpty()){
			isValid = false;
			ErrorMessage = "Customer Password Can't be Empty \n";
		}
				
		//Check whether all the validations are passed
		if(isValid){
			//Populate the Bean Class then parsist into the database
			CustomerBean customerBean = new CustomerBean();
			customerBean.setCustomerAge(Integer.parseInt(CustomerAge));
			customerBean.setCustomerCell(CustomerCell);
			customerBean.setCustomerDesc(CustomerDesc);
			customerBean.setCustomerDL(CustomerDL.toUpperCase());
			customerBean.setCustomerEmail(CustomerEmail);
			customerBean.setCustomerName(CustomerName);
			customerBean.setCustomerPwd(CustomerPwd);
			
			new CustomerDAO().addCustomer(customerBean);
			
			returnObject.put(ServiceConstants.RESULT, ServiceConstants.OK);
			returnObject.put(ServiceConstants.RECORDS,customerBean);
		}else{
			returnObject.put(ServiceConstants.RESULT, ServiceConstants.ERROR);
			returnObject.put(ServiceConstants.MESSAGE, ErrorMessage);
		}
		
		System.out.println("AddProducts : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/UpdateCustomers")
	@Produces(MediaType.APPLICATION_JSON) 
	public String updateProducts(@Context HttpServletRequest request) throws JSONException {
	
		JSONObject returnObject = new JSONObject();
		
		System.out.println("UpdateProducts : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/DeleteCustomers")
	@Produces(MediaType.APPLICATION_JSON) 
	public String deleteProducts(@Context HttpServletRequest request) throws JSONException {
	
		JSONObject returnObject = new JSONObject();
		
		System.out.println("DeleteProducts : " + returnObject.toString());
		return returnObject.toString();
	}
	
	private boolean isIntegerParseInt(String str) {
	     try {
	           Integer.parseInt(str);
	            return true;
	        } catch (NumberFormatException nfe) {}
	        return false;
	}
	
	private boolean isEmailValid(String email){
		 String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
		 return email.matches(EMAIL_REGEX);			      
	}
	
	private boolean isValidEmailDL(String DL){
		
		if(DL.equalsIgnoreCase("North") || DL.equalsIgnoreCase("South") ||
				DL.equalsIgnoreCase("East") || DL.equalsIgnoreCase("West")){
			return true;
		}else{
			return false;
		}
	}
}
