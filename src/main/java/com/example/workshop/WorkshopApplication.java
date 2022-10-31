package com.example.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class WorkshopApplication {

//	@Bean
//	public User xxx() {
//		return new User();
//	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context
				= SpringApplication.run(WorkshopApplication.class, args);
		String[] beans = context.getBeanDefinitionNames();
		for (String bean : beans) {
			System.out.println(bean);
		}
		System.out.println(context.getBeanDefinitionCount());
	}

}
