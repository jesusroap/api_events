package com.example.events.models;

import java.time.LocalDateTime;

public class EventDTO {
	private int id;
	
	private String name;
	
	private String description;
	
	private LocalDateTime date;
	
	private String location;
	
	private String planner;
	
	private String picture;
	
	public EventDTO() {}
	
	public EventDTO(Event event) {
		this.id = event.getId();
		this.name = event.getName();
		this.description = event.getDescription();
		this.date = event.getDate();
		this.location = event.getLocation();
		this.planner = event.getPlanner();
		this.picture = event.getPicture();
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getPlanner() {
		return planner;
	}


	public void setPlanner(String planner) {
		this.planner = planner;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}	 
}
