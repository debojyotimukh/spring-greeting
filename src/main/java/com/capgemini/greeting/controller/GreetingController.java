package com.capgemini.greeting.controller;

import com.capgemini.greeting.model.Greeting;
import com.capgemini.greeting.model.User;
import com.capgemini.greeting.service.IGreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping(value = { "", "/", "/home" })
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }
}
