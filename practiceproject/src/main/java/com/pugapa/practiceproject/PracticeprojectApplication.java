package com.pugapa.practiceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

@SpringBootApplication
public class PracticeprojectApplication {

	public static void main(String[] args) {

		// Setting active profile programatically
		var app=new SpringApplication(PracticeprojectApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));

		ConfigurableApplicationContext context=app.run(args);
		MyFirstService mfc=context.getBean(MyFirstService.class);
		System.out.println(mfc.tellAStory());
		System.out.println(mfc.getMyProp());
		System.out.println(mfc.getMyIntProp());
		System.out.println(mfc.getCustomProp());
		System.out.println(mfc.getCustomProp2());
	}

}
