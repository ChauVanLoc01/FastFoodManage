package models.product;

import java.util.Date;

import models.PersonObserver;

public class Rate {
	private double rating;
	private String content;
	private PersonObserver personObserver;
	private Date created;

	public Rate(double rating, String content, PersonObserver personObserver) {
		this.rating = rating;
		this.content = content;
		this.personObserver = personObserver;
		this.created = new Date();
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PersonObserver getPersonObserver() {
		return personObserver;
	}

	public void setPersonObserver(PersonObserver personObserver) {
		this.personObserver = personObserver;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	public void change(double rating, String content) {
		setRating(rating);
		setContent(content);
	}

}
