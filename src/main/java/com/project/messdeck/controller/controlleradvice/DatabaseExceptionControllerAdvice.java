package com.project.messdeck.controller.controlleradvice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.project.messdeck.businessException.ValidationException;
import com.project.messdeck.controller.exceptions.ErrorInfo;
import com.project.messdeck.exceptions.InvalidOpreationException;

@ControllerAdvice
public class DatabaseExceptionControllerAdvice {
	private static Logger logger = Logger.getLogger(DatabaseExceptionControllerAdvice.class);

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ DataIntegrityViolationException.class, })
	public @ResponseBody ErrorInfo handleDatabseExceptions(HttpServletRequest req,
			DataIntegrityViolationException exception) {
		logger.debug(exception.getMessage(), exception);
		// exception.printStackTrace();
		if (exception.getMostSpecificCause() instanceof MySQLIntegrityConstraintViolationException) {
			return new ErrorInfo(req.getRequestURL().toString(),
					((MySQLIntegrityConstraintViolationException) exception.getMostSpecificCause())
							.getLocalizedMessage());

		}

		return new ErrorInfo(req.getRequestURL().toString(), exception.getMessage());

	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ HttpMessageNotReadableException.class, })
	public @ResponseBody ErrorInfo handleHttpMessageNotReadableException(HttpServletRequest req,
			HttpMessageNotReadableException exception) {
		logger.debug("Unable to convert Json Into DTO", exception);

		return new ErrorInfo(req.getRequestURL().toString(), exception.getMessage());

	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ RuntimeException.class, })
	public @ResponseBody ErrorInfo handleRunTimeExceptions(HttpServletRequest req, RuntimeException exception) {
		logger.debug(exception.getMessage(), exception);
		return new ErrorInfo(req.getRequestURL().toString(), exception.getMessage());

	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ InvalidOpreationException.class })
	public @ResponseBody ErrorInfo handleInvalidOpreationException(HttpServletRequest req,
			InvalidOpreationException exception) {
		return new ErrorInfo(req.getRequestURL().toString(), exception.getMessage());

	}
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ ValidationException.class, })
	public @ResponseBody List<ValidationErrrorInfo> handleValidationExceptions(HttpServletRequest req,
			ValidationException exception) {
		// exception.printStackTrace();
		// logger.debug(exception.getMessage(), exception);
		return exception.getViolationList();

	}
}
