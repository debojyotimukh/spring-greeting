package com.capgemini.greeting.repository;


import com.capgemini.greeting.model.Greeting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
