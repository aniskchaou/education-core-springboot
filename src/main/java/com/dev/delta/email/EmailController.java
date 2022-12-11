package com.dev.delta.email;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email/")
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
public class EmailController {

	@Autowired
	EmailService emailService;

	@Autowired
	EmailSettingRepository emailSettingRepository;

	@PostMapping(value = "/sendemail")
	public String sendEmail(@RequestBody String body, @RequestBody String subject, @RequestBody String receiver)
			throws AddressException, MessagingException, IOException {
		Long id = 1L;
		EmailSetting emailSetting = emailSettingRepository.getById(id);
		emailService.sendmail(emailSetting.auth, emailSetting.enableTLS, emailSetting.host, emailSetting.port,
				emailSetting.email, receiver, emailSetting.password, body, subject);
		return "Email sent successfully";
	}

}
