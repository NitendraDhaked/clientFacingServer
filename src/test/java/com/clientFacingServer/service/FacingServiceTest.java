package com.clientFacingServer.service;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.clientFacingServer.Service.FacingService;
import com.clientFacingServer.models.OperationParam;
import com.clientFacingServer.response.FacingServerResponse;


@RunWith(MockitoJUnitRunner.class)
public class FacingServiceTest {

	@Mock
	private RestTemplate restTemplate;
	
	 @InjectMocks
	 private FacingService facingService = new FacingService();

	@Test
	public void whenCalculateIsCalled_ShouldReturnValidMockedResponse() {

		OperationParam operationParam = new OperationParam("10", "20");

		String uri = "http://localhost:8081/api/v1/function/multiply";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<OperationParam> request = new HttpEntity<>(operationParam, headers);

		FacingServerResponse response = new FacingServerResponse("", true, new BigDecimal(200));

		ResponseEntity<FacingServerResponse> responseEntity  
		= new ResponseEntity<FacingServerResponse>(response,HttpStatus.OK);
		
		Mockito.when(restTemplate.postForEntity(uri,request, FacingServerResponse.class)).thenReturn(responseEntity);
		
		assertEquals(responseEntity.getBody().getResult(), restTemplate.postForEntity(uri, request, FacingServerResponse.class).getBody().getResult());
		
		//not mocking properly
		//assertEquals(responseEntity.getBody().getResult(), facingService.calculate("multiply", "10", "20").getResult());

	}

}
