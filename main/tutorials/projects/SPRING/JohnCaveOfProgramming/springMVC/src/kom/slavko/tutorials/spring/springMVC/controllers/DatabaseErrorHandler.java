package kom.slavko.tutorials.spring.springMVC.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseErrorHandler {

	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseExceptions(DataAccessException ex) {
		ex.printStackTrace();
		return "error";

	}
}
