package com.pugapa.practiceproject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayHello()
    {
       return "Hello From My First Controller";
    }

    @GetMapping("/hello-2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2()
    {
        return "Hello2 From My First Controller";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message)
    {
        return "Request Accepted and message : "+message;
    }

    @PostMapping("/post-order")
    public String post(@RequestBody Order order)
    {
        return "Request Accepted and message : "+order.toString();
    }

    @PostMapping("/post-order-record")
    public String post(@RequestBody OrderRecord order)
    {
        return "Request Accepted and message : "+order.toString();
    }
//
//    @GetMapping("/hello/{}")
//    public String pathVar(@PathVariable String username)
//    {
//        return "Hello "+username;
//    }

    @GetMapping("/hello/{user-name}")
    public String pathVar2(@PathVariable("user-name") String username)
    {
        return "Hello "+username;
    }

}
