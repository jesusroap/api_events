package com.example.events.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.example.events.models.Event;

public interface EventsRepositories extends Repository<Event, Integer> {
	public List<Event> findAll();
	public Event findById(int id);
	public Event save(Event event);
	public Event delete(Event event);
}
