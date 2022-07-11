package com.cltech.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@Builder(toBuilder = true)
public class ResponseBean {
	private Status status;
	private String message;
	private Object response;
	
//	@Override
//	public String toString() {
//		return "ResponseBean {status:" + status + ", message:" + message + ", response:" + response + ", getClass()="
//				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "}";
//	}

	public ResponseBean(Status status, String message, Object response) {
		super();
		this.status = status;
		this.message = message;
		this.response = response;
	}

	public static String builder(Status fail, String string2, Object string3) {
		// TODO Auto-generated method stub
		return "{status:" + fail + ", message:" + string2 + ", response:" + string3+"}";
}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	
	
	

}
