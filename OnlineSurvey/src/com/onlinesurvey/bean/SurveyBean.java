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
@Entity(name = "survey_table")
public class SurveyBean {

	@Id @GeneratedValue	
	private Long SurveyId;
	
	@Column(name="ProductId")
	private Long ProductId;
	
	@Column(name="CustomerDL")
	private String CustomerDL;
	
	@Column(name="SurveyName")
	private String SurveyName;
	
	@Column(name="SurveyDesc")
	private String SurveyDesc;
	
	@Column(name="Question_1")
	private String Question_1;
	
	@Column(name="Option_1_1")
	private String Option_1_1;
	
	@Column(name="Option_1_2")
	private String Option_1_2;
	
	@Column(name="Option_1_3")
	private String Option_1_3;
	
	@Column(name="Option_1_4")
	private String Option_1_4;
	
	@Column(name="Question_2")
	private String Question_2;
	
	@Column(name="Option_2_1")
	private String Option_2_1;
	
	@Column(name="Option_2_2")
	private String Option_2_2;
	
	@Column(name="Option_2_3")
	private String Option_2_3;
	
	@Column(name="Option_2_4")
	private String Option_2_4;
	
	@Column(name="Question_3")
	private String Question_3;
	
	@Column(name="Option_3_1")
	private String Option_3_1;
	
	@Column(name="Option_3_2")
	private String Option_3_2;
	
	@Column(name="Option_3_3")
	private String Option_3_3;
	
	@Column(name="Option_3_4")
	private String Option_3_4;
	
	@Column(name="Question_4")
	private String Question_4;
	
	@Column(name="Option_4_1")
	private String Option_4_1;
	
	@Column(name="Option_4_2")
	private String Option_4_2;
	
	@Column(name="Option_4_3")
	private String Option_4_3;
	
	@Column(name="Option_4_4")
	private String Option_4_4;
	
	@Column(name="Question_5")
	private String Question_5;
	
	@Column(name="Option_5_1")
	private String Option_5_1;
	
	@Column(name="Option_5_2")
	private String Option_5_2;
	
	@Column(name="Option_5_3")
	private String Option_5_3;
	
	@Column(name="Option_5_4")
	private String Option_5_4;
	
	@Column(name="Question_6")
	private String Question_6;
	
	@Column(name="Option_6_1")
	private String Option_6_1;
	
	@Column(name="Option_6_2")
	private String Option_6_2;
	
	@Column(name="Option_6_3")
	private String Option_6_3;
	
	@Column(name="Option_6_4")
	private String Option_6_4;
	
	@Column(name="Question_7")
	private String Question_7;
	
	@Column(name="Option_7_1")
	private String Option_7_1;
	
	@Column(name="Option_7_2")
	private String Option_7_2;
	
	@Column(name="Option_7_3")
	private String Option_7_3;
	
	@Column(name="Option_7_4")
	private String Option_7_4;
	
	@Column(name="Question_8")
	private String Question_8;
	
	@Column(name="Option_8_1")
	private String Option_8_1;
	
	@Column(name="Option_8_2")
	private String Option_8_2;
	
	@Column(name="Option_8_3")
	private String Option_8_3;
	
	@Column(name="Option_8_4")
	private String Option_8_4;
	
	@Column(name="Question_9")
	private String Question_9;
	
	@Column(name="Option_9_1")
	private String Option_9_1;
	
	@Column(name="Option_9_2")
	private String Option_9_2;
	
	@Column(name="Option_9_3")
	private String Option_9_3;
	
	@Column(name="Option_9_4")
	private String Option_9_4;
	
	@Column(name="Question_10")
	private String Question_10;
	
	@Column(name="Option_10_1")
	private String Option_10_1;
	
	@Column(name="Option_10_2")
	private String Option_10_2;
	
	@Column(name="Option_10_3")
	private String Option_10_3;
	
	@Column(name="Option_10_4")
	private String Option_10_4;
	
	public Long getSurveyId() {
		return SurveyId;
	}
	
	public void setSurveyId(Long surveyId) {
		SurveyId = surveyId;
	}
	
	public Long getProductId() {
		return ProductId;
	}
	
	public void setProductId(Long productId) {
		ProductId = productId;
	}
	
	public String getCustomerDL() {
		return CustomerDL;
	}
	
	public void setCustomerDL(String customerDL) {
		CustomerDL = customerDL;
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
	
	public String getQuestion_1() {
		return Question_1;
	}
	
	public void setQuestion_1(String question_1) {
		Question_1 = question_1;
	}
	
	public String getOption_1_1() {
		return Option_1_1;
	}
	
	public void setOption_1_1(String option_1_1) {
		Option_1_1 = option_1_1;
	}
	
	public String getOption_1_2() {
		return Option_1_2;
	}
	
	public void setOption_1_2(String option_1_2) {
		Option_1_2 = option_1_2;
	}
	
	public String getOption_1_3() {
		return Option_1_3;
	}
	
	public void setOption_1_3(String option_1_3) {
		Option_1_3 = option_1_3;
	}
	
	public String getOption_1_4() {
		return Option_1_4;
	}
	
	public void setOption_1_4(String option_1_4) {
		Option_1_4 = option_1_4;
	}
	
	public String getQuestion_2() {
		return Question_2;
	}
	
	public void setQuestion_2(String question_2) {
		Question_2 = question_2;
	}
	
	public String getOption_2_1() {
		return Option_2_1;
	}
	
	public void setOption_2_1(String option_2_1) {
		Option_2_1 = option_2_1;
	}
	
	public String getOption_2_2() {
		return Option_2_2;
	}
	
	public void setOption_2_2(String option_2_2) {
		Option_2_2 = option_2_2;
	}
	
	public String getOption_2_3() {
		return Option_2_3;
	}
	
	public void setOption_2_3(String option_2_3) {
		Option_2_3 = option_2_3;
	}
	
	public String getOption_2_4() {
		return Option_2_4;
	}
	
	public void setOption_2_4(String option_2_4) {
		Option_2_4 = option_2_4;
	}
	
	public String getQuestion_3() {
		return Question_3;
	}
	
	public void setQuestion_3(String question_3) {
		Question_3 = question_3;
	}
	
	public String getOption_3_1() {
		return Option_3_1;
	}
	
	public void setOption_3_1(String option_3_1) {
		Option_3_1 = option_3_1;
	}
	
	public String getOption_3_2() {
		return Option_3_2;
	}
	
	public void setOption_3_2(String option_3_2) {
		Option_3_2 = option_3_2;
	}
	
	public String getOption_3_3() {
		return Option_3_3;
	}
	
	public void setOption_3_3(String option_3_3) {
		Option_3_3 = option_3_3;
	}
	
	public String getOption_3_4() {
		return Option_3_4;
	}
	
	public void setOption_3_4(String option_3_4) {
		Option_3_4 = option_3_4;
	}
	
	public String getQuestion_4() {
		return Question_4;
	}
	
	public void setQuestion_4(String question_4) {
		Question_4 = question_4;
	}
	
	public String getOption_4_1() {
		return Option_4_1;
	}
	
	public void setOption_4_1(String option_4_1) {
		Option_4_1 = option_4_1;
	}
	
	public String getOption_4_2() {
		return Option_4_2;
	}
	
	public void setOption_4_2(String option_4_2) {
		Option_4_2 = option_4_2;
	}
	
	public String getOption_4_3() {
		return Option_4_3;
	}
	
	public void setOption_4_3(String option_4_3) {
		Option_4_3 = option_4_3;
	}
	
	public String getOption_4_4() {
		return Option_4_4;
	}
	
	public void setOption_4_4(String option_4_4) {
		Option_4_4 = option_4_4;
	}
	
	public String getQuestion_5() {
		return Question_5;
	}
	
	public void setQuestion_5(String question_5) {
		Question_5 = question_5;
	}
	
	public String getOption_5_1() {
		return Option_5_1;
	}
	
	public void setOption_5_1(String option_5_1) {
		Option_5_1 = option_5_1;
	}
	
	public String getOption_5_2() {
		return Option_5_2;
	}
	
	public void setOption_5_2(String option_5_2) {
		Option_5_2 = option_5_2;
	}
	
	public String getOption_5_3() {
		return Option_5_3;
	}
	
	public void setOption_5_3(String option_5_3) {
		Option_5_3 = option_5_3;
	}
	
	public String getOption_5_4() {
		return Option_5_4;
	}
	
	public void setOption_5_4(String option_5_4) {
		Option_5_4 = option_5_4;
	}
	
	public String getQuestion_6() {
		return Question_6;
	}
	
	public void setQuestion_6(String question_6) {
		Question_6 = question_6;
	}
	
	public String getOption_6_1() {
		return Option_6_1;
	}
	
	public void setOption_6_1(String option_6_1) {
		Option_6_1 = option_6_1;
	}
	
	public String getOption_6_2() {
		return Option_6_2;
	}
	
	public void setOption_6_2(String option_6_2) {
		Option_6_2 = option_6_2;
	}
	
	public String getOption_6_3() {
		return Option_6_3;
	}
	
	public void setOption_6_3(String option_6_3) {
		Option_6_3 = option_6_3;
	}
	
	public String getOption_6_4() {
		return Option_6_4;
	}
	
	public void setOption_6_4(String option_6_4) {
		Option_6_4 = option_6_4;
	}
	
	public String getQuestion_7() {
		return Question_7;
	}
	
	public void setQuestion_7(String question_7) {
		Question_7 = question_7;
	}
	
	public String getOption_7_1() {
		return Option_7_1;
	}
	
	public void setOption_7_1(String option_7_1) {
		Option_7_1 = option_7_1;
	}
	
	public String getOption_7_2() {
		return Option_7_2;
	}
	
	public void setOption_7_2(String option_7_2) {
		Option_7_2 = option_7_2;
	}
	
	public String getOption_7_3() {
		return Option_7_3;
	}
	
	public void setOption_7_3(String option_7_3) {
		Option_7_3 = option_7_3;
	}
	
	public String getOption_7_4() {
		return Option_7_4;
	}
	
	public void setOption_7_4(String option_7_4) {
		Option_7_4 = option_7_4;
	}
	
	public String getQuestion_8() {
		return Question_8;
	}
	
	public void setQuestion_8(String question_8) {
		Question_8 = question_8;
	}
	
	public String getOption_8_1() {
		return Option_8_1;
	}
	
	public void setOption_8_1(String option_8_1) {
		Option_8_1 = option_8_1;
	}
	
	public String getOption_8_2() {
		return Option_8_2;
	}
	
	public void setOption_8_2(String option_8_2) {
		Option_8_2 = option_8_2;
	}
	
	public String getOption_8_3() {
		return Option_8_3;
	}
	
	public void setOption_8_3(String option_8_3) {
		Option_8_3 = option_8_3;
	}
	
	public String getOption_8_4() {
		return Option_8_4;
	}
	
	public void setOption_8_4(String option_8_4) {
		Option_8_4 = option_8_4;
	}
	
	public String getQuestion_9() {
		return Question_9;
	}
	
	public void setQuestion_9(String question_9) {
		Question_9 = question_9;
	}
	
	public String getOption_9_1() {
		return Option_9_1;
	}
	
	public void setOption_9_1(String option_9_1) {
		Option_9_1 = option_9_1;
	}
	
	public String getOption_9_2() {
		return Option_9_2;
	}
	
	public void setOption_9_2(String option_9_2) {
		Option_9_2 = option_9_2;
	}
	
	public String getOption_9_3() {
		return Option_9_3;
	}
	
	public void setOption_9_3(String option_9_3) {
		Option_9_3 = option_9_3;
	}
	
	public String getOption_9_4() {
		return Option_9_4;
	}
	
	public void setOption_9_4(String option_9_4) {
		Option_9_4 = option_9_4;
	}
	
	public String getQuestion_10() {
		return Question_10;
	}
	
	public void setQuestion_10(String question_10) {
		Question_10 = question_10;
	}
	
	public String getOption_10_1() {
		return Option_10_1;
	}
	
	public void setOption_10_1(String option_10_1) {
		Option_10_1 = option_10_1;
	}
	
	public String getOption_10_2() {
		return Option_10_2;
	}
	
	public void setOption_10_2(String option_10_2) {
		Option_10_2 = option_10_2;
	}
	
	public String getOption_10_3() {
		return Option_10_3;
	}
	
	public void setOption_10_3(String option_10_3) {
		Option_10_3 = option_10_3;
	}
	
	public String getOption_10_4() {
		return Option_10_4;
	}
	
	public void setOption_10_4(String option_10_4) {
		Option_10_4 = option_10_4;
	}
		
}
