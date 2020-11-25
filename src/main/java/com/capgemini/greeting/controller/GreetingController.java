package com.capgemini.greeting.controller;

import java.util.List;

import com.capgemini.greeting.model.Greeting;
import com.capgemini.greeting.model.User;
import com.capgemini.greeting.service.IGreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @GetMapping(value = "/query")
    public Greeting getGreeting(@RequestParam(value = "id") long id) {
        return greetingService.getGreetingById(id);
    }

    @PostMapping(value = "/")
    public Greeting greeting(@RequestBody User user) {
        return greetingService.addGreeting(user);
    }

    @GetMapping(value = "/query/messages")
    public List<String> getAll(){
        return greetingService.getAllMessages();
    }

}
