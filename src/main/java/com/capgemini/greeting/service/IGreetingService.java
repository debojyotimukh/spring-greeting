package com.capgemini.greeting.service;

import java.util.List;

import com.capgemini.greeting.model.Greeting;
import com.capgemini.greeting.model.User;

public interface IGreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);

    List<String> getAllMessages();

    boolean editMessage(long id, String newMessage);

    boolean delete(long id);
}
