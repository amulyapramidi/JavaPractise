package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping(value="/book/{bookName}", method=RequestMethod.GET)
	public String getBook(@PathVariable("bookName") String bookName) throws Exception
	{
		System.out.println("Request handled : "+bookName);
		if(bookName.equalsIgnoreCase("error"))
			throw new Exception();
		else
			return "BookName : "+bookName;
		
	}
	
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e)
	{
	System.out.println("Inside generic exception handler");
	return "DefaultErrorPage";
	}}
