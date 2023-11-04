package com.example.events.services;

import java.util.List;

import com.example.events.models.EventDTO;

public interface IEventsService {
	public List<EventDTO> getAllEvents();

	EventDTO getEvent(int id);
}
