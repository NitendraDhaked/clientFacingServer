package com.clientFacingServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clientFacingServer.Service.FacingService;
import com.clientFacingServer.response.FacingServerResponse;
import com.clientFacingServer.util.AppConstants;


@RestController
@RequestMapping(AppConstants.FACING_API_PATH)
public class FacingController {
	
	@Autowired
	FacingService facingService;
	
	@RequestMapping(method = RequestMethod.GET)
	public  FacingServerResponse calculate(@RequestParam String operation, @RequestParam String operand1, @RequestParam String operand2) {
		
		return facingService.calculate(operation, operand1, operand2);
	}

}
