package se.l4.ylem.types.conversion;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class StandardTypeConverterTest
{

	@Test
	public void testLongToString()
	{
		TypeConverter tc = new StandardTypeConverter();
		String out = tc.convert(10l, String.class);
		assertThat(out, is("10"));
	}
}
