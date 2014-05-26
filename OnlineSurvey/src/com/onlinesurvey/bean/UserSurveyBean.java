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
@Entity(name = "usersurvey_table")
public class UserSurveyBean {

	@Id @GeneratedValue	
	private Long UserSurveyId;
	
	@Column(name="SurveyId")	
	private Long SurveyId;
	
	@Column(name="SurveyName")
	private String SurveyName;
	
	@Column(name="SurveyDesc")
	private String SurveyDesc;
	
	@Column(name="CustomerName")
	private String CustomerName;

	@Column(name="CustomerDesc")
	private String CustomerDesc;

	@Column(name="CustomerEmail")
	private String CustomerEmail;
	
	@Column(name="UserResponse")
	private String UserResponse;
	
	@Column(name="Question_1")
	private String Question_1;
	
	@Column(name="Question_2")
	private String Question_2;
	
	@Column(name="Question_3")
	private String Question_3;
	
	@Column(name="Question_4")
	private String Question_4;
	
	@Column(name="Question_5")
	private String Question_5;
	
	@Column(name="Question_6")
	private String Question_6;
	
	@Column(name="Question_7")
	private String Question_7;
	
	@Column(name="Question_8")
	private String Question_8;
	
	@Column(name="Question_9")
	private String Question_9;
	
	@Column(name="Question_10")
	private String Question_10;

	public Long getUserSurveyId() {
		return UserSurveyId;
	}

	public void setUserSurveyId(Long userSurveyId) {
		UserSurveyId = userSurveyId;
	}

	public Long getSurveyId() {
		return SurveyId;
	}

	public void setSurveyId(Long surveyId) {
		SurveyId = surveyId;
	}

	public String getSurveyName() {
		return SurveyName;
	}

	public void setSurveyName(String surveyName) {
		SurveyName = surveyName;
	}

	public String getSurveyDesc() {
		return SurveyDesc;
	}

	public void setSurveyDesc(String surveyDesc) {
		SurveyDesc = surveyDesc;
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

	public String getCustomerEmail() {
		return CustomerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}

	public String getUserResponse() {
		return UserResponse;
	}

	public void setUserResponse(String userResponse) {
		UserResponse = userResponse;
	}

	public String getQuestion_1() {
		return Question_1;
	}

	public void setQuestion_1(String question_1) {
		Question_1 = question_1;
	}

	public String getQuestion_2() {
		return Question_2;
	}

	public void setQuestion_2(String question_2) {
		Question_2 = question_2;
	}

	public String getQuestion_3() {
		return Question_3;
	}

	public void setQuestion_3(String question_3) {
		Question_3 = question_3;
	}

	public String getQuestion_4() {
		return Question_4;
	}

	public void setQuestion_4(String question_4) {
		Question_4 = question_4;
	}

	public String getQuestion_5() {
		return Question_5;
	}

	public void setQuestion_5(String question_5) {
		Question_5 = question_5;
	}

	public String getQuestion_6() {
		return Question_6;
	}

	public void setQuestion_6(String question_6) {
		Question_6 = question_6;
	}

	public String getQuestion_7() {
		return Question_7;
	}

	public void setQuestion_7(String question_7) {
		Question_7 = question_7;
	}

	public String getQuestion_8() {
		return Question_8;
	}

	public void setQuestion_8(String question_8) {
		Question_8 = question_8;
	}

	public String getQuestion_9() {
		return Question_9;
	}

	public void setQuestion_9(String question_9) {
		Question_9 = question_9;
	}

	public String getQuestion_10() {
		return Question_10;
	}

	public void setQuestion_10(String question_10) {
		Question_10 = question_10;
	}
	
	
}
