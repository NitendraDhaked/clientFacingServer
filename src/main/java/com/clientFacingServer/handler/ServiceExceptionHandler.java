package com.clientFacingServer.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.clientFacingServer.response.FacingServerResponse;

@ControllerAdvice("com.clientFacingServer.controllers")
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<FacingServerResponse> handleAllExceptions(Exception ex, WebRequest request) {
		FacingServerResponse res = new FacingServerResponse();
		res.setMessage(ex.getMessage());
		res.setSuccess(false);
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
