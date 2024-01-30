package com.pugapa.practiceproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
// Spring can scan properties provided in application.properties only .
// Inorder to read properties defined in other files we need to provide PropertySource
// @PropertySource("classpath:custom.properties")

// Inorder to provide multiple PropertySources
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom2.properties")
})

public class MyFirstService {

    private final MyFirstClass myFirstClass;

    @Value("${my.custom.property}")
    private String myProp;

    @Value("${my.prop}")
    private String customProp;

    @Value("${my.prop2}")
    private String customProp2;

    // Constructor bean injection
    public MyFirstService(@Qualifier("myFirstClass") MyFirstClass myFirstClass)
    {
        this.myFirstClass=myFirstClass;
    }

    public String tellAStory()
    {
      return "the dependency is saying "+myFirstClass.sayHello();
    }

    public String getMyProp()
    {
        return myProp;
    }

    public String getCustomProp()
    {
        return customProp;
    }

    public String getCustomProp2()
    {
        return customProp2;
    }

}
