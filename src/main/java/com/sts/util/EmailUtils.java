package com.sts.util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import lombok.experimental.Helper;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(String subject, String body, String to,File f) {
		
		try {
			MimeMessage mimeMsg=mailSender.createMimeMessage();
			MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMsg, true);
			messageHelper.setSubject(subject);
			messageHelper.setText(body, true);
			messageHelper.setTo(to);
			messageHelper.addAttachment("Plans-Info", f);
			
			mailSender.send(mimeMsg);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return true;
		
	}

}
