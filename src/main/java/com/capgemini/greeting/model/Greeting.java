package com.capgemini.greeting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GREETINGS")
public class Greeting {
	@Id
	private long id;
	private String message;

	public Greeting(long id, String message) {
		this.id = id;
		this.message = message;

	}

	public Greeting get() {
		return null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Greeting() {
		this.id = 0;
		this.message = "";
	}

}
