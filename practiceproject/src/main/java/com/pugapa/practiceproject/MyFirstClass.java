package com.pugapa.practiceproject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public class MyFirstClass {

    private String myVar;
    public MyFirstClass (String myVar)
    {
        this.myVar=myVar;
    }

    public String sayHello()
    {
        return "Hello From My First Class ===> myVar = "+myVar;
    }

}
