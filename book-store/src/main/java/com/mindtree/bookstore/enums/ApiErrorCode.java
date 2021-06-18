package com.mindtree.bookstore.enums;

public enum ApiErrorCode {

	// 400s
	DEFAULT_400(400, "badRequest", "This is a bad request."),
	BAD_PARAMETER(400, "badParameter", "One or more parameters were invalid."),
	PARSE_ERROR(400, "parseError", "Could not parse the request body."),
	MISSING_PARAMETER(400, "missingParameter", "One or more required parameters are missing"),

	// 404s
	DEFAULT_404(404, "notFound", "Not found"),

	// 409s
	NOT_ALLOWED(409, "notAllowed", "Negative quantity is not allowed"),

	// 500s
	DEFAULT_500(500, "internalServerError", "internal server error");

	private final int httpStatus;
	private final String code;
	private final String message;

	private ApiErrorCode(int httpStatus, String code, String message) {
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
