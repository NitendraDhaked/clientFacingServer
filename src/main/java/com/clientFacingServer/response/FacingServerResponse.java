package com.clientFacingServer.response;

import java.math.BigDecimal;

public class FacingServerResponse {
	
	
	private String message;
	private boolean success = false;
	private BigDecimal result = null;
	
	public FacingServerResponse() {
	}
	
	public FacingServerResponse(String message, boolean success, BigDecimal result) {
		this.message = message;
		this.success = success;
		this.result = result;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public BigDecimal getResult() {
		return result;
	}
	public void setResult(BigDecimal result) {
		this.result = result;
	}
	
}
