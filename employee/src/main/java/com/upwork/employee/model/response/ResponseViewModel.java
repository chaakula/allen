package com.upwork.employee.model.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Response view model interface, this is super interface all the view models
 * should implement this
 * 
 * @author Chandra Sekhar Babu A
 *
 */
@JsonInclude(Include.NON_NULL)
public interface ResponseViewModel extends Serializable {

	
}