package com.Li.exception;

public class InventoryException extends Exception
{
	public InventoryException(String message)
	{
		super("InventoryException-"+ message);
	}
	
	public InventoryException(String message, Throwable cause)
	{
		super("InventoryException-"+ message,cause);
	}
}