package com.example.events.models;

public class ResponseDTO {
	private String message;
	
	private Boolean success;
	
	public ResponseDTO(String message) {
        this.message = message;
        this.success = false;
    }
	
	public ResponseDTO(String message, Boolean success) {
		this.message = message;
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
}
