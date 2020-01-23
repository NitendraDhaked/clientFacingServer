package com.clientFacingServer.models;

import java.math.BigDecimal;

public class OperationParam {
	
	protected BigDecimal operand1;
	
	public BigDecimal getOperand1() {
		return operand1;
	}

	public void setOperand1(BigDecimal operand1) {
		this.operand1 = operand1;
	}

	public BigDecimal getOperand2() {
		return operand2;
	}

	public void setOperand2(BigDecimal operand2) {
		this.operand2 = operand2;
	}

	protected BigDecimal operand2;
	
	public OperationParam(String operand1, String operand2) {
		
		this.operand1 = new BigDecimal(operand1);
		this.operand2 = new BigDecimal(operand2);
	}

}
