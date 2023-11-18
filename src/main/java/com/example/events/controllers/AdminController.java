package com.example.events.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.events.models.EventDTO;
import com.example.events.models.ResponseDTO;
import com.example.events.models.UserDTO;
import com.example.events.services.IAdminService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	
	@PostMapping("/login")
	public ResponseDTO login(@RequestBody UserDTO user) {
		return adminService.login(user);
	}
	
	@PostMapping("/save")
	public ResponseDTO saveEvent(@RequestBody EventDTO event) {
		return adminService.saveEvent(event);
	}
	
	@PutMapping("/edit")
	public ResponseDTO updateEvent(@RequestBody EventDTO event) {
		return adminService.updateEvent(event);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseDTO deleteEvent(@PathVariable int id) {
		return adminService.deleteEvent(id);
	}
	
	@PostMapping("/file_upload")
    public ResponseDTO fileUpload(@RequestParam("file") MultipartFile file) {
        return adminService.fileUpload(file);
    }
}
