/**
 * 
 */
package com.onlinesurvey.service;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
@Path("/UserSurvey")
public class UserSurveyService {

	@Path("/GetUserSurvey")
	@POST	
	@Produces(MediaType.APPLICATION_JSON) 
	public String getUserSurvey() throws JSONException {
				
		JSONObject returnObject = new JSONObject();	
		JSONArray returnArray = new JSONArray();
		
		List<SurveyBean> allSurvey = new SurveyDAO().getAllSurvey();
		
		return null;
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
}
