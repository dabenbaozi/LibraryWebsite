package com.Li.exception;

public class BookException extends Exception
{
	public BookException(String message)
	{
		super("BookException-"+ message);
	}
	
	public BookException(String message, Throwable cause)
	{
		super("BookException-"+ message,cause);
	}
}