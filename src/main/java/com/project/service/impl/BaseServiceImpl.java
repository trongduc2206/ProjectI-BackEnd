package com.project.service.impl;

import com.project.component.MessageTranslator;
import com.project.constant.MessageConstant;
import com.project.domain.GeneralResponse;
import com.project.domain.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BaseServiceImpl {

	@Autowired
	private MessageTranslator translator;


	protected <T extends GeneralResponse> T generateResponse(T data) {
		data.setStatus(new ResponseStatus(MessageConstant.SUCCESS, translator.getMessage(MessageConstant.SUCCESS)));
		return data;
	}
	
	protected <T extends GeneralResponse> T generateResponse(T data,String code) {
		data.setStatus(new ResponseStatus(code, translator.getMessage(code)));
		return data;
	} 
	
	protected <T extends GeneralResponse> ResponseEntity<T> success(T data) {
		data.setStatus(new ResponseStatus(MessageConstant.SUCCESS, translator.getMessage(MessageConstant.SUCCESS)));
		return ResponseEntity.ok(data);
	} 
	
	protected <T extends GeneralResponse> ResponseEntity<T> successWithStatus(T data, HttpStatus status) {
		data.setStatus(new ResponseStatus(MessageConstant.SUCCESS, translator.getMessage(MessageConstant.SUCCESS)));
		return ResponseEntity.status(status).body(data);
	} 
	
	protected <T extends GeneralResponse> ResponseEntity<T> error(T data,String code) {
		data.setStatus(new ResponseStatus(code, translator.getMessage(code)));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(data);
	} 
	
	protected <T extends GeneralResponse> ResponseEntity<T> errorWithStatus(T data, HttpStatus status,String code) {
		data.setStatus(new ResponseStatus(code, translator.getMessage(code)));
		return ResponseEntity.status(status).body(data);
	} 
	
}
