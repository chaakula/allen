package com.upwork.employee.model.response;

/**
 * 
 * @author Chandra Sekhar Babu A
 *
 */
public class ProfileResponse implements ResponseViewModel {

	private static final long serialVersionUID = -1129635238576032502L;

	private String message;
	private String statusCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
