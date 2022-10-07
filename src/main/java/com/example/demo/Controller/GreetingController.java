package com.example.demo.Controller;

import com.example.demo.Model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static int counter = 1;
    private final String template = "Hello %s!";
    private final Logger logger;

    public GreetingController(){
        logger = LoggerFactory.getLogger("Logger");
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "User")String name){
        logger.info(name);
        return new Greeting(incrementCounter(), String.format(template, name));
    }

    private static int incrementCounter(){
        return counter++;

    }
}
