package com.pugapa.practiceproject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
// sets this configuration class available for only given active profile
// @Profile("test")
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

    @Bean("Bean1")
    @Profile("dev")
    public MyFirstClass myFirstBean()
    {
        return new MyFirstClass("FirstDevBean");
    }

    @Bean("Bean2")
    @Profile("test")
    public MyFirstClass mySecondBean()
    {
        return new MyFirstClass("SecondTestBean");
    }
}
