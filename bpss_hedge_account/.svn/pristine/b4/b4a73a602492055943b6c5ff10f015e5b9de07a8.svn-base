package br.com.bpss.hg.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource(value = "classpath:env/mail.properties")
public class ConfigMail {

	@Autowired
	private Environment env;

	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(env.getProperty("mail.smtp.host"));
		mailSender.setPort(env.getProperty("mail.smtp.porta", Integer.class));
		mailSender.setUsername(env.getProperty("mail.smtp.usuario"));
		mailSender.setPassword(env.getProperty("mail.smtp.senha"));

		Properties props = new Properties();

		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.connectiontimeout", 5000);

		mailSender.setJavaMailProperties(props);

		return mailSender;
	}

}
