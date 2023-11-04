package com.example.events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.events.models.EventDTO;
import com.example.events.repositories.EventsRepositories;

@Service
public class EventsService implements IEventsService {
	
	@Autowired
	EventsRepositories eventsRepositories;

	@Override
	public List<EventDTO> getAllEvents() {
		// TODO Auto-generated method stub
		return eventsRepositories.findAll();
	}
	
	@Override
	public EventDTO getEvent(int id) {
		EventDTO event = eventsRepositories.findById(id);
		if (event != null) {
			return event;
		} else {
			return new EventDTO();
		}
	}
	
}
