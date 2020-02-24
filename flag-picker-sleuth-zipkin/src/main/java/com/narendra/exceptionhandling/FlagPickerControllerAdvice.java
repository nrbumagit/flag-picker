package com.narendra.exceptionhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.narendra.exceptions.FlagPickerException;

@ControllerAdvice
public class FlagPickerControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody FlagPickerException handleCheckedException(HttpServletRequest request, Exception exp) {
		FlagPickerException exception = new FlagPickerException(exp.getMessage(),request.getRequestURI());
		return exception;
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody FlagPickerException handleUncheckedException(HttpServletRequest request, Exception exp) {
		FlagPickerException exception = new FlagPickerException(exp.getMessage(),request.getRequestURI());
		return exception;
	}

}
