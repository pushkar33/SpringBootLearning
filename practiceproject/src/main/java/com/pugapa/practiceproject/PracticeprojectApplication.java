package com.pugapa.practiceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PracticeprojectApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context=SpringApplication.run(PracticeprojectApplication.class, args);
		MyFirstService mfc=context.getBean(MyFirstService.class);
		System.out.println(mfc.tellAStory());
		System.out.println(mfc.getMyProp());
		System.out.println(mfc.getCustomProp());
		System.out.println(mfc.getCustomProp2());
	}

}
