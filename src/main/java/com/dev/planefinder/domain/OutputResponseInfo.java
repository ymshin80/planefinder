package com.dev.planefinder.domain;

import java.io.Serializable;

import org.springframework.http.HttpStatus;


public class OutputResponseInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3680254279709419041L;
	private HttpStatus response_state;
	private Object payload;
	@Override
	public String toString() {
		return "OutputRequestInfo [response_state=" + response_state + ", payload=" + payload + "]";
	}
	public HttpStatus getResponse_state() {
		return response_state;
	}
	public void setResponse_state(HttpStatus response_state) {
		this.response_state = response_state;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
	
	
	
	
}
