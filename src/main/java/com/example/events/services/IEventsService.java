package com.example.events.services;

import java.util.List;

import com.example.events.models.EventDTO;
import com.example.events.models.ResponseDTO;

public interface IEventsService {
	public List<EventDTO> getAllEvents();

	public EventDTO getEvent(int id);
}
