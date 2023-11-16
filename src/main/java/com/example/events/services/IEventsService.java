package com.example.events.services;

import java.util.List;

import com.example.events.models.EventDTO;

public interface IEventsService {
	public List<EventDTO> getAllEvents();

	public EventDTO getEvent(int id);
	
	public String saveEvent(EventDTO event);
	
	public String updateEvent(EventDTO event);
	
	public String deleteEvent(int id);
}
