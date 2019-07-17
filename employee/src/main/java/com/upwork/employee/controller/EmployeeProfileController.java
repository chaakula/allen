package com.upwork.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upwork.employee.common.RestURLConstants;
import com.upwork.employee.entity.Employee;
import com.upwork.employee.exception.AppException;
import com.upwork.employee.model.request.UserDetails;
import com.upwork.employee.response.viewmodel.AppResponse;
import com.upwork.employee.service.IEmployeeProfileService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Employee Registration controller
 * 
 * @author Chandra Sekhar Babu A
 *
 */
@RestController
@RequestMapping(RestURLConstants.EMPLOYEE_API_REST_URL)
public class EmployeeProfileController {

	@Autowired
	IEmployeeProfileService empProfileService;

	@ApiOperation(value = "Employee Profile update service", response = AppResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Profile updated successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping(value = RestURLConstants.EMPLOYEE_UPDATE_PROFILE_REST_URL, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppResponse> updateProfile(@RequestBody final UserDetails userDetails) throws AppException {
		System.out.println("Request received");
		if (userDetails.isValidRequest()) {
			UserDetails resp = empProfileService.updateProfile(userDetails);
			AppResponse appResponse = new AppResponse();
			appResponse.setResponseViewModel(resp);

			return ResponseEntity.ok(appResponse);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
