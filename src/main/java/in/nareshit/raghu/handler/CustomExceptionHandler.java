package in.nareshit.raghu.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.nareshit.raghu.exception.ProductNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(
			ProductNotFoundException e) 
	{
		
		return new ResponseEntity<String>(
				e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
