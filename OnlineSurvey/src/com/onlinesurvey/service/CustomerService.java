/**
 * 
 */
package com.onlinesurvey.service;

import java.util.List;

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
		
		List<CustomerBean> allCustomers = new CustomerDAO().getAllCustomer();
		
		for (int i = 0; i < allCustomers.size(); i++) {  
			CustomerBean customerBean = (CustomerBean) allCustomers.get(i);  
			JSONObject record = populateJSON(customerBean);
			returnArray.put(record);
		} 		
					
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
			
			Long CustomerId = new CustomerDAO().addCustomer(customerBean);
			
			customerBean.setCustomerId(CustomerId);
			//populate the JSON object
			JSONObject record = populateJSON(customerBean);
			JSONArray returnArray = new JSONArray();
			
			returnArray.put(record);
			
			returnObject.put(ServiceConstants.RESULT, ServiceConstants.OK);
			returnObject.put(ServiceConstants.RECORDS,returnArray);
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
		String CustomerId = request.getParameter("CustomerId");
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
			customerBean.setCustomerId(Long.parseLong(CustomerId));
			
			new CustomerDAO().updateCustomer(customerBean);			
			
			//populate the JSON object
			JSONObject record = populateJSON(customerBean);
			JSONArray returnArray = new JSONArray();
			
			returnArray.put(record);
			
			returnObject.put(ServiceConstants.RESULT, ServiceConstants.OK);
			returnObject.put(ServiceConstants.RECORDS,returnArray);
		}else{
			returnObject.put(ServiceConstants.RESULT, ServiceConstants.ERROR);
			returnObject.put(ServiceConstants.MESSAGE, ErrorMessage);
		}
		
		System.out.println("AddProducts : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/DeleteCustomers")
	@Produces(MediaType.APPLICATION_JSON) 
	public String deleteProducts(@Context HttpServletRequest request) throws JSONException {
	
		String CustomerId = request.getParameter("CustomerId");
		Long custId = Long.parseLong(CustomerId);
		
		new CustomerDAO().deleteCustomer(custId);
		
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
	 * Check for valid Email Address
	 * @param email
	 * @return
	 */
	private boolean isEmailValid(String email){
		 String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
		 return email.matches(EMAIL_REGEX);			      
	}
	
	/**
	 * Check for Valid Email DL
	 * @param DL
	 * @return
	 */
	private boolean isValidEmailDL(String DL){
		
		if(DL.equalsIgnoreCase("North") || DL.equalsIgnoreCase("South") ||
				DL.equalsIgnoreCase("East") || DL.equalsIgnoreCase("West")){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Populate the JSON object
	 * @param customerBean
	 * @return
	 * @throws JSONException
	 */
	private JSONObject populateJSON(CustomerBean customerBean) throws JSONException{

		JSONObject returnObj = new JSONObject();
		returnObj.put("CustomerAge", customerBean.getCustomerAge());
		returnObj.put("CustomerCell", customerBean.getCustomerCell());
		returnObj.put("CustomerDesc", customerBean.getCustomerDesc());
		returnObj.put("CustomerDL", customerBean.getCustomerDL());
		returnObj.put("CustomerEmail", customerBean.getCustomerEmail());
		returnObj.put("CustomerId", customerBean.getCustomerId());
		returnObj.put("CustomerName", customerBean.getCustomerName());
		returnObj.put("CustomerPwd", customerBean.getCustomerPwd());
		
		return returnObj;
	}
}
