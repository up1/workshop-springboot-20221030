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

		User u1 = new User();
		User u2 = context.getBean(User.class);
		u2.setName("Name U2");
		User u3 = context.getBean(User.class);
		u3.setName("Name U3");

		System.out.println(u2.getName());
		System.out.println(u3.getName());
	}

}
