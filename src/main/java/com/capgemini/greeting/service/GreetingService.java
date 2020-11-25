package com.capgemini.greeting.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import com.capgemini.greeting.model.Greeting;
import com.capgemini.greeting.model.User;
import com.capgemini.greeting.repository.GreetingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty() ? "World!" : user.toString()));
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<String> getAllMessages() {
        return greetingRepository.findAll().stream().map(greeting -> greeting.getMessage())
                .collect(Collectors.toList());
    }


    @Override
    public boolean delete(long id) {
        // TODO Auto-generated method stub
        return false;
    }

	@Override
	public boolean editMessage(long id, String newMessage) {
		// TODO Auto-generated method stub
		return false;
	}

}
