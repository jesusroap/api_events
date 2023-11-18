package com.example.events.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.events.models.Event;
import com.example.events.models.EventDTO;
import com.example.events.models.ResponseDTO;
import com.example.events.repositories.EventsRepositories;

@Service
public class EventsService implements IEventsService {
	
	private EventsRepositories eventsRepositories;
	
	@Autowired
	public EventsService(EventsRepositories eventsRepositories) {
		this.eventsRepositories = eventsRepositories;
	}

	@Override
	public List<EventDTO> getAllEvents() {
		List<Event> events = eventsRepositories.findAll();
		
		
		List<EventDTO> eventsDTO = events.stream()
				.map(EventDTO::new)
				.collect(Collectors.toList());
		 
		return eventsDTO;
	}
	
	@Override
	public EventDTO getEvent(int id) {
		Event event = eventsRepositories.findById(id);
		
//		EventDTO eventDTO = event.map(EventDTO::new)
//				.orElse(new EventDTO());
		
		EventDTO eventDTO = new EventDTO();
		
		if (event != null) {
			eventDTO = new EventDTO(event);
		}
				
		return eventDTO;
	}
	
}
