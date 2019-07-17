package com.upwork.employee.healthcheck;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.upwork.employee.common.RestURLConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HealthCheckController {

	@ApiOperation(value = "Employee server status", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Server is up and running"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = RestURLConstants.PING, method = RequestMethod.GET)
	public String healthCheck() {
		return "Employee server is up and Running....";
	}

}
