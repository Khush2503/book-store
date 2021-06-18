package com.mindtree.bookstore.exception;

import java.security.InvalidParameterException;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import com.mindtree.bookstore.enums.ApiErrorCode;
import com.mindtree.bookstore.exception.resource.ErrorResource;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErrorResource> handleApplicationException(ApplicationException exception) {
		return exception.getResponse();
	}

	@ExceptionHandler({ MissingServletRequestParameterException.class, MissingServletRequestPartException.class,
			ConstraintViolationException.class })
	public ResponseEntity<ErrorResource> handleMissingParameters(Exception exception) {
		ApiErrorCode apiErrorCode = ApiErrorCode.MISSING_PARAMETER;
		ErrorResource error = new ErrorResource(apiErrorCode, exception.getMessage());
		return new ResponseEntity<>(error, HttpStatus.valueOf(apiErrorCode.getHttpStatus()));
	}

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class, InvalidParameterException.class,
			IllegalStateException.class })
	public ResponseEntity<ErrorResource> handleMethodArgumentTypeMismatch(Exception exception) {
		ApiErrorCode apiErrorCode = ApiErrorCode.BAD_PARAMETER;
		ErrorResource error = new ErrorResource(apiErrorCode);
		return new ResponseEntity<>(error, HttpStatus.valueOf(apiErrorCode.getHttpStatus()));
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorResource> handleUnsupportedEnpoint(HttpRequestMethodNotSupportedException exception) {
		ApiErrorCode apiErrorCode = ApiErrorCode.DEFAULT_404;
		ErrorResource error = new ErrorResource(apiErrorCode);
		return new ResponseEntity<>(error, HttpStatus.valueOf(apiErrorCode.getHttpStatus()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResource> handleIncorrectBody(MethodArgumentNotValidException exception) {
		BindingResult result = exception.getBindingResult();
		ApiErrorCode apiErrorCode = ApiErrorCode.BAD_PARAMETER;
		ErrorResource errorResource = new ErrorResource(apiErrorCode, result.getFieldError().getDefaultMessage());
		return new ResponseEntity<>(errorResource, HttpStatus.valueOf(apiErrorCode.getHttpStatus()));
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ErrorResource> handleException(Throwable exception) {
		ApiErrorCode apiErrorCode = ApiErrorCode.DEFAULT_500;
		ErrorResource error = new ErrorResource(apiErrorCode);
		return new ResponseEntity<>(error, HttpStatus.valueOf(apiErrorCode.getHttpStatus()));
	}

}
