package com.almeda.jpa01onetooneuni.exceptionhandler;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.almeda.jpa01onetooneuni.exceptionhandler.exceptions.InstructorIdNotFoundException;

/**
 * @author aldo
 * @RestControllerAdvice = @ControllerAdvice + @ResponseBody
 * @RestControllerAdvice se debe utilizar para servicios rest
 * ResponseEntityExceptionHandler: trata las excepciones más comunes
 *
 */
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	/*
	@ExceptionHandler({InstructorIdNotFoundException.class})
	public final ResponseEntity<MensajeError> handleNotFoundException(InstructorIdNotFoundException ex, WebRequest request) {
		MensajeError exceptionResponse = new MensajeError(LocalDateTime.now(), 
														ex.getMessage(),
														ex.getCause().toString(),
														HttpStatus.NOT_FOUND.getReasonPhrase(),
														request.getDescription(false));
	    return new ResponseEntity<MensajeError>(exceptionResponse, HttpStatus.NOT_FOUND);
	}*/
	
	@ExceptionHandler(InstructorIdNotFoundException.class)
	public final ResponseEntity<MensajeError> handleNotFoundException(InstructorIdNotFoundException ex, HttpServletRequest request) {
		MensajeError exceptionResponse = new MensajeError(LocalDateTime.now(), 
															ex.getMessage(),
															"Not Found Exception",															
															String.valueOf(HttpStatus.NOT_FOUND.value()),
															request.getRequestURI());
	    return new ResponseEntity<MensajeError>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	/*
	 @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<ErrorInfo> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
       ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());
       return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
   }
	 
	 */
	
	/*
	 @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
        return error(INTERNAL_SERVER_ERROR, e);
    }
    @ExceptionHandler({DogsNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(DogsNotFoundException e) {
        return error(NOT_FOUND, e);
    }
    @ExceptionHandler({DogsServiceException.class})
    public ResponseEntity<String> handleDogsServiceException(DogsServiceException e){
        return error(INTERNAL_SERVER_ERROR, e);
    }
    private ResponseEntity<String> error(HttpStatus status, Exception e) {
        log.error("Exception : ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
	 */
	
	/*
	 
	 @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({DogsNotFoundException.class})
    public void handle(DogsNotFoundException e) {}
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({DogsServiceException.class, SQLException.class, NullPointerException.class})
    public void handle() {}
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DogsServiceValidationException.class})
    public void handle(DogsServiceValidationException e) {} 
	 */
	
}
