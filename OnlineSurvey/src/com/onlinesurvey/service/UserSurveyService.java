/**
 * 
 */
package com.onlinesurvey.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.onlinesurvey.bean.SurveyBean;
import com.onlinesurvey.bean.UserSurveyBean;
import com.onlinesurvey.dao.SurveyDAO;
import com.onlinesurvey.dao.UserSurveyDAO;

/**
 * @author Viresh
 *
 */
@Path("/UserSurvey")
public class UserSurveyService {

	@Path("/GetAllUserSurvey")
	@POST	
	@Produces(MediaType.APPLICATION_JSON) 
	public String getUserSurvey() throws JSONException {
				
		JSONObject returnObject = new JSONObject();	
		JSONArray returnArray = new JSONArray();
		
		List<UserSurveyBean> allUserSurvey = new UserSurveyDAO().getAllSurvey();
		
		for (int i = 0; i < allUserSurvey.size(); i++) {  
			UserSurveyBean surveyBean = (UserSurveyBean) allUserSurvey.get(i);  
			JSONObject record = populateJSON(surveyBean);
			returnArray.put(record);
		} 		
					
		returnObject.put(ServiceConstants.RESULT, ServiceConstants.OK);
		returnObject.put(ServiceConstants.RECORDS,returnArray);
		
		System.out.println("GetProducts : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@POST
	@Path("/NoOperation")
	@Produces(MediaType.APPLICATION_JSON) 
	public String updateSurvey(@Context HttpServletRequest request) throws JSONException {
	
		JSONObject returnObject = new JSONObject();
		
		returnObject.put(ServiceConstants.RESULT, ServiceConstants.ERROR);
		returnObject.put(ServiceConstants.MESSAGE, "Can't Add or Modify or delete user responses");
		
		System.out.println(" : " + returnObject.toString());
		return returnObject.toString();
	}
	
	@Path("/AddUserSurvey")
	@POST	
	@Produces(MediaType.APPLICATION_JSON) 
	public String addUserSurvey() throws JSONException {
				
		JSONObject returnObject = new JSONObject();	
		JSONArray returnArray = new JSONArray();
		
		List<SurveyBean> allSurvey = new SurveyDAO().getAllSurvey();
		
		return null;
	}
	
	@Path("/UpdateUserSurvey")
	@POST	
	@Produces(MediaType.APPLICATION_JSON) 
	public String updateUserSurvey() throws JSONException {
				
		JSONObject returnObject = new JSONObject();	
		JSONArray returnArray = new JSONArray();
		
		List<SurveyBean> allSurvey = new SurveyDAO().getAllSurvey();
		
		return null;
	}
	
	/**
	 * Populate the Bean object
	 * @param userSurveyBean
	 * @return
	 * @throws JSONException
	 */
	private JSONObject populateJSON(UserSurveyBean userSurveyBean) throws JSONException{

		JSONObject returnObj = new JSONObject();
		returnObj.put("UserSurveyId",userSurveyBean.getUserSurveyId());
		returnObj.put("SurveyName",userSurveyBean.getSurveyName());
		returnObj.put("SurveyDesc",userSurveyBean.getSurveyDesc());
		returnObj.put("CustomerName",userSurveyBean.getCustomerName());	
		returnObj.put("CustomerDesc",userSurveyBean.getCustomerDesc());	
		returnObj.put("CustomerEmail",userSurveyBean.getCustomerEmail());	
		returnObj.put("UserResponse",userSurveyBean.getUserResponse());	
		
		return returnObj;
	}
}
