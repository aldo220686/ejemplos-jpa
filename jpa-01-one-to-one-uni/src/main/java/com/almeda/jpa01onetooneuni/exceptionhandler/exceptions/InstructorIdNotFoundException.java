package com.almeda.jpa01onetooneuni.exceptionhandler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InstructorIdNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -1456117636457204848L;

	private static final String message = "El id del instructor no se ha encontrado";
	
	public InstructorIdNotFoundException() {
		super(message);
	}

	public InstructorIdNotFoundException(String detailMessage) {
		super(message + ", " + detailMessage);
	}
}
