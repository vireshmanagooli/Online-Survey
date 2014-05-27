package com.onlinesurvey.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailMail
{
	private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(String dear, String content, String[] to) {

		SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);
		
		message.setTo(to);
		message.setText(String.format(
				simpleMailMessage.getText(), dear, content));

		mailSender.send(message);
		
	}
	
	
}
