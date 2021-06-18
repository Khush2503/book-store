package com.mindtree.bookstore.exception.resource;

import com.mindtree.bookstore.enums.ApiErrorCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResource {

	private int status;

	private String code;

	private String message;

	public ErrorResource(int status, String code, String message) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public ErrorResource(ApiErrorCode apiError) {
		this.status = apiError.getHttpStatus();
		this.code = apiError.getCode();
		this.message = apiError.getMessage();
	}

	public ErrorResource(ApiErrorCode apiError, String message) {
		this.status = apiError.getHttpStatus();
		this.code = apiError.getCode();
		this.message = apiError.getMessage();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorResource other = (ErrorResource) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
