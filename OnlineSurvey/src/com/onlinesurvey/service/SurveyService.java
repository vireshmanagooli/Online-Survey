/**
 * 
 */
package com.onlinesurvey.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.onlinesurvey.bean.CustomerBean;
import com.onlinesurvey.bean.SurveyBean;
import com.onlinesurvey.bean.UserSurveyBean;
import com.onlinesurvey.dao.CustomerDAO;
import com.onlinesurvey.dao.SurveyDAO;
import com.onlinesurvey.dao.UserSurveyDAO;

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
	
	@Path("/GetSurvey/{SurveyId}")
	@POST	
	@Produces(MediaType.APPLICATION_JSON) 
	public String getSurveyForCustomer(@PathParam("SurveyId") Long SurveyId) throws JSONException {
				
		JSONObject returnObject = new JSONObject();	
		JSONArray returnArray = new JSONArray();
		
		List<SurveyBean> allSurvey = new SurveyDAO().getSurvey(SurveyId);
		
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
					
		SurveyBean bean = populateBean(request);
		
		Long returnId = new SurveyDAO().addSurvey(bean);
		
		if(returnId != -1){
			returnObject.put(ServiceConstants.RESULT, ServiceConstants.OK);
			
			//Get the user email Ids for the particular DL
			List<CustomerBean> customerList = new CustomerDAO().getCustomersFromDL(bean.getCustomerDL());
			
			for (int i = 0; i < customerList.size(); i++) {  
				
				CustomerBean customerBean = customerList.get(i);
				//Add the newly created survey to userSurvey_table for each email id
				UserSurveyBean userSurveyBean = new UserSurveyBean();
				
				userSurveyBean.setSurveyId(returnId);
				userSurveyBean.setSurveyDesc(bean.getSurveyDesc());				
				userSurveyBean.setSurveyName(bean.getSurveyName());
				userSurveyBean.setCustomerDesc(customerBean.getCustomerDesc());
				userSurveyBean.setCustomerEmail(customerBean.getCustomerEmail());
				userSurveyBean.setCustomerName(customerBean.getCustomerName());
				userSurveyBean.setUserResponse("N");
				
				new UserSurveyDAO().addSurvey(userSurveyBean);
				
				//Send the Email to the each email.
			} 
			
		}else{
			
			returnObject.put(ServiceConstants.RESULT, ServiceConstants.ERROR);
			returnObject.put(ServiceConstants.MESSAGE, "Survey Can't be added from the table. Please use below add survey button");					
		}
		
		System.out.println("CreateSurvey : " + returnObject.toString());
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
		
		returnObj.put("Question_1",surveyBean.getQuestion_1());
		returnObj.put("Option_1_1",surveyBean.getOption_1_1());
		returnObj.put("Option_1_2",surveyBean.getOption_1_2());
		returnObj.put("Option_1_3",surveyBean.getOption_1_3());
		returnObj.put("Option_1_4",surveyBean.getOption_1_4());
		
		returnObj.put("Question_2",surveyBean.getQuestion_2());
		returnObj.put("Option_2_1",surveyBean.getOption_2_1());
		returnObj.put("Option_2_2",surveyBean.getOption_2_2());
		returnObj.put("Option_2_3",surveyBean.getOption_2_3());
		returnObj.put("Option_2_4",surveyBean.getOption_2_4());
		
		returnObj.put("Question_3",surveyBean.getQuestion_3());
		returnObj.put("Option_3_1",surveyBean.getOption_3_1());
		returnObj.put("Option_3_2",surveyBean.getOption_3_2());
		returnObj.put("Option_3_3",surveyBean.getOption_3_3());
		returnObj.put("Option_3_4",surveyBean.getOption_3_4());
		
		returnObj.put("Question_4",surveyBean.getQuestion_4());
		returnObj.put("Option_4_1",surveyBean.getOption_4_1());
		returnObj.put("Option_4_2",surveyBean.getOption_4_2());
		returnObj.put("Option_4_3",surveyBean.getOption_4_3());
		returnObj.put("Option_4_4",surveyBean.getOption_4_4());
		
		returnObj.put("Question_5",surveyBean.getQuestion_5());
		returnObj.put("Option_5_1",surveyBean.getOption_5_1());
		returnObj.put("Option_5_2",surveyBean.getOption_5_2());
		returnObj.put("Option_5_3",surveyBean.getOption_5_3());
		returnObj.put("Option_5_4",surveyBean.getOption_5_4());
		
		returnObj.put("Question_6",surveyBean.getQuestion_6());
		returnObj.put("Option_6_1",surveyBean.getOption_6_1());
		returnObj.put("Option_6_2",surveyBean.getOption_6_2());
		returnObj.put("Option_6_3",surveyBean.getOption_6_3());
		returnObj.put("Option_6_4",surveyBean.getOption_6_4());
		
		returnObj.put("Question_7",surveyBean.getQuestion_7());
		returnObj.put("Option_7_1",surveyBean.getOption_7_1());
		returnObj.put("Option_7_2",surveyBean.getOption_7_2());
		returnObj.put("Option_7_3",surveyBean.getOption_7_3());
		returnObj.put("Option_7_4",surveyBean.getOption_7_4());
		
		returnObj.put("Question_8",surveyBean.getQuestion_8());
		returnObj.put("Option_8_1",surveyBean.getOption_8_1());
		returnObj.put("Option_8_2",surveyBean.getOption_8_2());
		returnObj.put("Option_8_3",surveyBean.getOption_8_3());
		returnObj.put("Option_8_4",surveyBean.getOption_8_4());
		
		returnObj.put("Question_9",surveyBean.getQuestion_9());
		returnObj.put("Option_9_1",surveyBean.getOption_9_1());
		returnObj.put("Option_9_2",surveyBean.getOption_9_2());
		returnObj.put("Option_9_3",surveyBean.getOption_9_3());
		returnObj.put("Option_9_4",surveyBean.getOption_9_4());
		
		returnObj.put("Question_10",surveyBean.getQuestion_10());
		returnObj.put("Option_10_1",surveyBean.getOption_10_1());
		returnObj.put("Option_10_2",surveyBean.getOption_10_2());
		returnObj.put("Option_10_3",surveyBean.getOption_10_3());
		returnObj.put("Option_10_4",surveyBean.getOption_10_4());
		return returnObj;
	}
	
	/**
	 * Method to populate the Bean object
	 * @param request
	 * @return
	 */
	private SurveyBean populateBean(HttpServletRequest request){
		SurveyBean bean = new SurveyBean();
		
		
		bean.setSurveyName(request.getParameter("SurveyName"));
		bean.setSurveyDesc(request.getParameter("SurveyDesc"));
		bean.setProductId(Long.parseLong(request.getParameter("productName")));
		bean.setCustomerDL(request.getParameter("CustomerDL"));
		
		bean.setQuestion_1(request.getParameter("Question_1"));
		bean.setOption_1_1(request.getParameter("Option_1_1"));
		bean.setOption_1_2(request.getParameter("Option_1_2"));
		bean.setOption_1_3(request.getParameter("Option_1_3"));
		bean.setOption_1_4(request.getParameter("Option_1_4"));
		
		bean.setQuestion_2(request.getParameter("Question_2"));
		bean.setOption_2_1(request.getParameter("Option_2_1"));
		bean.setOption_2_2(request.getParameter("Option_2_2"));
		bean.setOption_2_3(request.getParameter("Option_2_3"));
		bean.setOption_2_4(request.getParameter("Option_2_4"));
		
		bean.setQuestion_3(request.getParameter("Question_3"));
		bean.setOption_3_1(request.getParameter("Option_3_1"));
		bean.setOption_3_2(request.getParameter("Option_3_2"));
		bean.setOption_3_3(request.getParameter("Option_3_3"));
		bean.setOption_3_4(request.getParameter("Option_3_4"));
		
		bean.setQuestion_4(request.getParameter("Question_4"));
		bean.setOption_4_1(request.getParameter("Option_4_1"));
		bean.setOption_4_2(request.getParameter("Option_4_2"));
		bean.setOption_4_3(request.getParameter("Option_4_3"));
		bean.setOption_4_4(request.getParameter("Option_4_4"));
		
		bean.setQuestion_5(request.getParameter("Question_5"));
		bean.setOption_5_1(request.getParameter("Option_5_1"));
		bean.setOption_5_2(request.getParameter("Option_5_2"));
		bean.setOption_5_3(request.getParameter("Option_5_3"));
		bean.setOption_5_4(request.getParameter("Option_5_4"));
		
		bean.setQuestion_6(request.getParameter("Question_6"));
		bean.setOption_6_1(request.getParameter("Option_6_1"));
		bean.setOption_6_2(request.getParameter("Option_6_2"));
		bean.setOption_6_3(request.getParameter("Option_6_3"));
		bean.setOption_6_4(request.getParameter("Option_6_4"));
		
		bean.setQuestion_7(request.getParameter("Question_7"));
		bean.setOption_7_1(request.getParameter("Option_7_1"));
		bean.setOption_7_2(request.getParameter("Option_7_2"));
		bean.setOption_7_3(request.getParameter("Option_7_3"));
		bean.setOption_7_4(request.getParameter("Option_7_4"));
		
		bean.setQuestion_8(request.getParameter("Question_8"));
		bean.setOption_8_1(request.getParameter("Option_8_1"));
		bean.setOption_8_2(request.getParameter("Option_8_2"));
		bean.setOption_8_3(request.getParameter("Option_8_3"));
		bean.setOption_8_4(request.getParameter("Option_8_4"));
		
		bean.setQuestion_9(request.getParameter("Question_9"));
		bean.setOption_9_1(request.getParameter("Option_9_1"));
		bean.setOption_9_2(request.getParameter("Option_9_2"));
		bean.setOption_9_3(request.getParameter("Option_9_3"));
		bean.setOption_9_4(request.getParameter("Option_9_4"));
		
		bean.setQuestion_10(request.getParameter("Question_10"));
		bean.setOption_10_1(request.getParameter("Option_10_1"));
		bean.setOption_10_2(request.getParameter("Option_10_2"));
		bean.setOption_10_3(request.getParameter("Option_10_3"));
		bean.setOption_10_4(request.getParameter("Option_10_4"));
		
		return bean;
	}
}
