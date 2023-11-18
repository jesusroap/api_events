package com.example.events.services;

import org.springframework.web.multipart.MultipartFile;

import com.example.events.models.EventDTO;
import com.example.events.models.ResponseDTO;
import com.example.events.models.UserDTO;

public interface IAdminService {
	public ResponseDTO login(UserDTO user);
	
	public ResponseDTO saveEvent(EventDTO event);
	
	public ResponseDTO updateEvent(EventDTO event);
	
	public ResponseDTO deleteEvent(int id);
	
	public ResponseDTO fileUpload(MultipartFile file);
}
