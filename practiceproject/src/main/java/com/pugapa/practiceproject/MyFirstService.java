package com.pugapa.practiceproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    // Field bean injection
//    @Autowired @Qualifier("mySecondClass")
    private MyFirstClass myFirstClass;

    // Environment Bean
    private Environment environment;

    // Constructor bean injection
//    public MyFirstService(@Qualifier("myFirstClass") MyFirstClass myFirstClass)
//    {
//        this.myFirstClass=myFirstClass;
//    }

    // Method bean injection
//   @Autowired
//    public void injectDependencies(@Qualifier("mySecondClass") MyFirstClass myFirstClass)
//    {
//        this.myFirstClass=myFirstClass;
//    }

    // Setter bean injection
    @Autowired
    public void setMyFirstClass(@Qualifier("mySecondClass") MyFirstClass myFirstClass)
    {
        this.myFirstClass=myFirstClass;
    }

    @Autowired
    public void setEnvironment(Environment environment)
    {
        this.environment=environment;
    }

    public String tellAStory()
    {
      return "the dependency is saying "+myFirstClass.sayHello();
    }

    public String getJavaVersion()
    {
        return environment.getProperty("java.version");
    }

    public String getOSName()
    {
        return environment.getProperty("os.name");
    }

    public String getCustomProperty()
    {
        return environment.getProperty("my.custom.property");
    }
}
