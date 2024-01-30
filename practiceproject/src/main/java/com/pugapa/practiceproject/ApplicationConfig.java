package com.pugapa.practiceproject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {

    @Bean
    public MyFirstClass myFirstClass()
    {
        return new MyFirstClass("FirstBean");
    }

    @Bean
    public MyFirstClass mySecondClass()
    {
        return new MyFirstClass("SecondBean");
    }
}
