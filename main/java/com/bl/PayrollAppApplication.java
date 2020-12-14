package com.bl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@Slf4j
public class PayrollAppApplication {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PayrollAppApplication.class);
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PayrollAppApplication.class, args);
		log.info("Employee Payroll App Started in {} Environment",
				context.getEnvironment().getProperty("environment"));
		log.info("Employee Payroll DB User is {} ",
				context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
