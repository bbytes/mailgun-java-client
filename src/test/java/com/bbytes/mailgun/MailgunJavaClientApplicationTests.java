package com.bbytes.mailgun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = { "com.bbytes.mailgun" })
@ContextConfiguration(classes=MailgunJavaClientApplicationTests.class)
@PropertySource("classpath:application.properties")
public class MailgunJavaClientApplicationTests {

	@Test
	public void contextLoads() {
	}

}
