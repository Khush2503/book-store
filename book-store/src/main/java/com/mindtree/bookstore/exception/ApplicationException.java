package com.mindtree.bookstore.exception;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mindtree.bookstore.enums.ApiErrorCode;
import com.mindtree.bookstore.exception.resource.ErrorResource;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	private String code = ApiErrorCode.DEFAULT_500.getCode();

	public ApplicationException(ApiErrorCode apiErrorCode) {
		this(apiErrorCode, apiErrorCode.getMessage());
	}

	public ApplicationException(ApiErrorCode apiErrorCode, String message) {
		this(apiErrorCode.getHttpStatus(), apiErrorCode.getCode(), message);
	}

	public ApplicationException(int status, String code, String message) {
		super(Optional.ofNullable(message).orElse(""));
		this.status = HttpStatus.valueOf(status);
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}

	public ResponseEntity<ErrorResource> getResponse() {
		ErrorResource errorResource = new ErrorResource(status.value(), code, getMessage());
		return ResponseEntity.status(status).body(errorResource);
	}

}
