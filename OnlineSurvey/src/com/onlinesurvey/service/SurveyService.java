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

import com.onlinesurvey.bean.SurveyBean;
import com.onlinesurvey.dao.SurveyDAO;

/**
 * @author Viresh
 *
 */
@Path("/Survey")
public class SurveyService {

	@Path("/GetSurvey")
	@POST	
	@Produces(MediaType.APPLICATION_JSON) 
	public String getSurvey(@QueryParam("jtStartIndex") int jtStartIndex,@QueryParam("jtPageSize") int jtPageSize, @QueryParam("jtSorting") String jtSorting,
			@QueryParam("callback") String callback) throws JSONException {
				
		JSONObject returnObject = new JSONObject();	
		JSONArray returnArray = new JSONArray();
		
		List<SurveyBean> allSurvey = new SurveyDAO().getAllSurvey();
		
		for (int i = 0; i < allSurvey.size(); i++) {  
			SurveyBean surveyBean = (SurveyBean) allSurvey.get(i);  
			JSONObject record = populateJSON(surveyBean);
			returnArray.put(record);
		} 		
					
		returnObject.put(ServiceConstants.RESULT, ServiceConstants.OK);
		returnObject.put(ServiceConstants.RECORDS,returnArray);
		
		System.out.println("GetProducts : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/AddSurvey")
	@Produces(MediaType.APPLICATION_JSON) 
	public String addSurvey(@Context HttpServletRequest request) throws JSONException {
	
		JSONObject returnObject = new JSONObject();
		
		returnObject.put(ServiceConstants.RESULT, ServiceConstants.ERROR);
		returnObject.put(ServiceConstants.MESSAGE, "Survey Can't be added from the table. Please use below add survey button");		
		
		System.out.println(" : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/CreateSurvey")
	@Produces(MediaType.APPLICATION_JSON) 
	public String createSurvey(@Context HttpServletRequest request) throws JSONException {
	
		JSONObject returnObject = new JSONObject();
		
		returnObject.put(ServiceConstants.RESULT, ServiceConstants.ERROR);
		returnObject.put(ServiceConstants.MESSAGE, "Survey Can't be added from the table. Please use below add survey button");		
		
		System.out.println(" : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/UpdateSurvey")
	@Produces(MediaType.APPLICATION_JSON) 
	public String updateSurvey(@Context HttpServletRequest request) throws JSONException {
	
		JSONObject returnObject = new JSONObject();
		
		returnObject.put(ServiceConstants.RESULT, ServiceConstants.ERROR);
		returnObject.put(ServiceConstants.MESSAGE, "Survey Once created can't be updated. It can be only deleted");
		
		System.out.println(" : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/DeleteSurvey")
	@Produces(MediaType.APPLICATION_JSON) 
	public String deleteSurvey(@Context HttpServletRequest request) throws JSONException {
	
		String SurveyId = request.getParameter("SurveyId");
		Long survId = Long.parseLong(SurveyId);
		
		new SurveyDAO().deleteSurvey(survId);
		
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
	private JSONObject populateJSON(SurveyBean surveyBean) throws JSONException{

		JSONObject returnObj = new JSONObject();
		returnObj.put("SurveyId",surveyBean.getSurveyId());
		returnObj.put("SurveyName",surveyBean.getSurveyName());
		returnObj.put("SurveyDesc",surveyBean.getSurveyName());
		returnObj.put("CustomerDL",surveyBean.getCustomerDL());		
		return returnObj;
	}
}
