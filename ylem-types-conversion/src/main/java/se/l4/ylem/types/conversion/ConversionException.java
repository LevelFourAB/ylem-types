package se.l4.ylem.types.conversion;

public class ConversionException
	extends RuntimeException
{
	public ConversionException(String message)
	{
		super(message);
	}

	public ConversionException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
