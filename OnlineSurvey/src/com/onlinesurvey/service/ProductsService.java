/**
 * 
 */
package com.onlinesurvey.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	@Path("/AddProducts")
	@Produces(MediaType.APPLICATION_JSON) 
	public String addProducts(@Context HttpServletRequest request) throws JSONException {
	
		JSONObject returnObject = new JSONObject();
		
		System.out.println("AddProducts : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/UpdateProducts")
	@Produces(MediaType.APPLICATION_JSON) 
	public String updateProducts(@Context HttpServletRequest request) throws JSONException {
	
		JSONObject returnObject = new JSONObject();
		
		System.out.println("UpdateProducts : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/DeleteProducts")
	@Produces(MediaType.APPLICATION_JSON) 
	public String deleteProducts(@Context HttpServletRequest request) throws JSONException {
	
		JSONObject returnObject = new JSONObject();
		
		System.out.println("DeleteProducts : " + returnObject.toString());
		return returnObject.toString();
	}
}
