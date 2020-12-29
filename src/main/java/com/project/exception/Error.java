package com.project.exception;

import java.io.Serializable;

public class Error implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String error;
	private String message;
	private String status;
	private String path;
	private String exception;
	private long timestamp;
	
	
	public Error(String error, String message, String status, String path, String exception, long timestamp) {
		super();
		this.error = error;
		this.message = message;
		this.status = status;
		this.path = path;
		this.exception = exception;
		this.timestamp = timestamp;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getException() {
		return exception;
	}


	public void setException(String exception) {
		this.exception = exception;
	}


	public long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
