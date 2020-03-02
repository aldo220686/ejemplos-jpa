package com.almeda.jpa01onetooneuni.exceptionhandler;

import java.time.LocalDateTime;

public class MensajeError {

	private LocalDateTime timestamp;
	private String mensaje;
	private String exception;
	private String statusCode;
	private String uriRequested;

	public MensajeError(LocalDateTime timestamp, Exception exception, String statusCode, String uriRequested) {
		this(timestamp, exception.getClass().getSimpleName(), exception.getMessage(), statusCode, uriRequested);
	}

	public MensajeError(LocalDateTime timestamp, String mensaje, String exception, String statusCode, String uriRequested) {
		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.exception = exception;
		this.statusCode = statusCode;
		this.uriRequested = uriRequested;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getException() {
		return exception;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getUriRequested() {
		return uriRequested;
	}

}
