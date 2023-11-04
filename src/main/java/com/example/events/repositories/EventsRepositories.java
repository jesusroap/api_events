package com.example.events.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.events.models.EventDTO;

public interface EventsRepositories extends Repository<EventDTO, Integer> {
	public List<EventDTO> findAll();
	public EventDTO findById(int id);
}
