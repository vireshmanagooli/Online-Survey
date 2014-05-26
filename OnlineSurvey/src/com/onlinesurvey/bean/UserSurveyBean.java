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
}
