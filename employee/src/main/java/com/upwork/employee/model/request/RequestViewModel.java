package com.upwork.employee.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.upwork.employee.model.response.ResponseViewModel;

/**
 * Root view model
 * 
 * @author Chandra Sekhar Babu A
 *
 */
@JsonInclude(Include.NON_NULL)
public class RequestViewModel implements ResponseViewModel{

	private static final long serialVersionUID = 5923228395216511649L;

	private String formKey;

	public String getFormKey() {
		return formKey;
	}

	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}

}
