package com.example.events.services;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.events.models.Event;
import com.example.events.models.EventDTO;
import com.example.events.models.ResponseDTO;
import com.example.events.models.User;
import com.example.events.models.UserDTO;
import com.example.events.repositories.EventsRepositories;
import com.example.events.repositories.UserRepositories;

import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobHttpHeaders;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobClient;

@Service
public class AdminService implements IAdminService {
	@Autowired
	private UserRepositories userRepositories;
	
	@Autowired
	private EventsRepositories eventsRepositories;
	
	@Autowired
    private Environment env;
	
	@Override
	public ResponseDTO login(UserDTO user) {		
		User userDB = userRepositories.findByEmail(user.getEmail());
		
		if (userDB != null && userDB.getPass().equals(user.getPass())) {
			return new ResponseDTO("Login Exitoso!", true);
		}

		return new ResponseDTO("Usuario o constraseña incorrectos.");
	}
	
	@Override
	public ResponseDTO saveEvent(EventDTO event) {
		if (event.getId() == 0) {
			try {
				Event e = new Event(event);
				eventsRepositories.save(e);
				return new ResponseDTO("El evento se guardo exitosamente.", true);
			} catch (Exception e) {
				return new ResponseDTO("Error al guardar el evento: " + e);
			}
		}
		
		return new ResponseDTO("El evento no se pudo guardar.");
	}
	
	@Override
	public ResponseDTO updateEvent(EventDTO event) {
		if (event.getId() != 0) {
			try {
				Event e = new Event(event);
				eventsRepositories.save(e);
				return new ResponseDTO("El evento se actualizo exitosamente.", true);
			} catch (Exception e) {
				return new ResponseDTO("Error al actualizar el evento: " + e);
			}
		}
		
		return new ResponseDTO("El evento no se pudo actualizar.");
	}
	
	@Override
	public ResponseDTO deleteEvent(int id) {
		Event event = eventsRepositories.findById(id);
				
		if (event != null) {
			try {
				eventsRepositories.delete(event);
				return new ResponseDTO("El evento se elimino exitosamente.", true);
			} catch (Exception e) {
				return new ResponseDTO("Error al eliminar el evento: " + e);
			}
		}
		
		return new ResponseDTO("El evento no se encontro en la base de datos.");
	}
	
	@Override
	public ResponseDTO fileUpload(MultipartFile file) {
		
        try {
//        	Path staticFolderPath = Paths.get(env.getProperty("URL_PICTURE") + fileName);
//            
//            System.out.println(staticFolderPath);
//
//            Files.copy(file.getInputStream(), staticFolderPath, StandardCopyOption.REPLACE_EXISTING);

            BlobServiceClientBuilder serviceClientBuilder = new BlobServiceClientBuilder().connectionString(env.getProperty("CONNECTION_STORAGE"));

            BlobContainerClient containerClient = serviceClientBuilder.buildClient().getBlobContainerClient(env.getProperty("CONTAINER_NAME"));

            BlobClient blobClientBuilder = containerClient.getBlobClient(file.getOriginalFilename());
            
            if (blobClientBuilder.exists()) {
                blobClientBuilder.delete();
            }
            
            BlobHttpHeaders blobHttpHeaders = new BlobHttpHeaders();
            blobHttpHeaders.setContentType(file.getContentType());
            
            try (InputStream dataStream = file.getInputStream()) {
                blobClientBuilder.upload(dataStream, file.getSize());
                blobClientBuilder.setHttpHeaders(blobHttpHeaders);
            }

            return new ResponseDTO("Archivo subido correctamente", true);
        } catch (IOException e) {
            return new ResponseDTO("Error al subir el archivo: " + e);
        }
	}
}
