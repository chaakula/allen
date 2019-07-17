package com.upwork.employee.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.upwork.employee.response.viewmodel.AppResponse;
import com.upwork.employee.response.viewmodel.ErrorResponse;

/**
 * ControllerAdvice class to handle to Exception handler for restful web
 * services
 * 
 * @author Chandra Sekhar Babu A
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * Illegal argument exceptions handler
	 * 
	 * @param invalidException
	 * @return
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<AppResponse> illegalArgumentExceptionHandler(IllegalArgumentException invalidException) {
		LOGGER.error(invalidException.getMessage(), invalidException);
		return new ResponseEntity<>(getResponse(invalidException.getMessage(), invalidException.getLocalizedMessage(),
				invalidException, HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Conversion failed exception, param values validation failed will come here or
	 * any conversion failed exceptions will handle in this method
	 * 
	 * @param convException
	 * @return
	 */
	@ExceptionHandler(ConversionFailedException.class)
	public ResponseEntity<AppResponse> conversionFailedExceptionHandler(ConversionFailedException convException) {
		LOGGER.error(convException.getMessage(), convException);
		return new ResponseEntity<>(getResponse(convException.getMessage(), convException.getLocalizedMessage(),
				convException, HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
	}

	/**
	 * App exception handler
	 * 
	 * @param appException
	 * @return
	 */
	@ExceptionHandler(AppException.class)
	public ResponseEntity<AppResponse> appExceptionHandler(AppException appException) {
		LOGGER.error(appException.getMessage(), appException);
		return new ResponseEntity<>(getResponse(appException.getMessage(), appException.getLocalizedMessage(),
				appException, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Exception handler
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<AppResponse> exceptionHandler(Exception exception) {
		LOGGER.error(exception.getMessage(), exception);
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ErrorCode.BAD_REQUEST.getMessage());
		return new ResponseEntity<AppResponse>(getResponse(exception.getMessage(), exception.getLocalizedMessage(),
				exception, HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);

	}

	/**
	 * Runtime Exception handler
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<AppResponse> exceptionHandler(RuntimeException exception) {
		LOGGER.error(exception.getMessage(), exception);
		return new ResponseEntity<>(getResponse(exception.getMessage(), exception.getLocalizedMessage(), exception,
				HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private AppResponse getResponse(String message, String localizedMessage, Exception ex, int statusCode) {
		AppResponse response = new AppResponse();
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(statusCode);
		error.setMessage(message);
		error.setLocalizedMessage(localizedMessage);
		response.setErrorViewModel(error);
		return response;
	}

}
