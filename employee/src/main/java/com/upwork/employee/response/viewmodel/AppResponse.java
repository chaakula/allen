package com.upwork.employee.response.viewmodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.upwork.employee.model.response.ResponseViewModel;

/**
 * App Response class, this will be exposed to UI, either success response or
 * error response
 * 
 * @author Chandra Sekhar Babu A
 *
 */
@JsonInclude(Include.NON_NULL)
public class AppResponse {

	@JsonProperty("success")
	Object responseViewModel;

	@JsonProperty("error")
	Object errorViewModel;

	@JsonProperty("warning")
	Object warningViewModel;

	public AppResponse() {
		super();
	}

	public AppResponse(ResponseViewModel responseViewModel, Object errorViewModel, Object warningViewModel) {
		super();
		this.responseViewModel = responseViewModel;
		this.errorViewModel = errorViewModel;
		this.warningViewModel = warningViewModel;
	}

	public Object getResponseViewModel() {
		return responseViewModel;
	}

	public void setResponseViewModel(Object responseViewModel) {
		this.responseViewModel = responseViewModel;
	}

	public Object getErrorViewModel() {
		return errorViewModel;
	}

	public void setErrorViewModel(Object errorViewModel) {
		this.errorViewModel = errorViewModel;
	}

	public Object getWarningViewModel() {
		return warningViewModel;
	}

	public void setWarningViewModel(Object warningViewModel) {
		this.warningViewModel = warningViewModel;
	}

}
