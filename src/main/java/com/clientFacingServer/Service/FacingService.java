package com.clientFacingServer.Service;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.clientFacingServer.models.OperationParam;
import com.clientFacingServer.response.FacingServerResponse;
import com.clientFacingServer.util.AppConstants;

@Service
public class FacingService {


	@Autowired
	RestTemplate restTemplate;

	public FacingServerResponse calculate(String operation, String operand1, String operand2) {
		// TODO Auto-generated method stub

		OperationParam operationParam = new OperationParam(operand1, operand2);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<OperationParam> entity = new HttpEntity<OperationParam>(operationParam,headers);
		
		String url = AppConstants.FUNCTION_SERVER_PATH +"/"+ operation;

		ResponseEntity<FacingServerResponse> responseEntity = restTemplate
				.postForEntity(url, entity, FacingServerResponse.class);

		return responseEntity.getBody();
	}

}
