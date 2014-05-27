package com.onlinesurvey.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	String [] To = {"abc@gmail.com","cde@gmail.com"};    	
    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("", "Dear, \n"+
				"We request you to be a part of survey and help us improve. \n"+
				"Click below link to participate \n"+
				"\n"+
				"http://127.0.0.1:8080/OnlineSurvey/"+
				"\n"+
				"Thanks,", To);
        
    } 
    
    /**
     * Invite the participants
     * @param To
     */
    public void inviteParticipants(String[] To){
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	    	
    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("", "Dear, \n"+
				"We request you to be a part of survey and help us improve. \n"+
				"Click below link to participate \n"+
				"\n"+
				"http://127.0.0.1:8080/OnlineSurvey/"+
				"\n"+
				"Thanks,", To);
    }
}
