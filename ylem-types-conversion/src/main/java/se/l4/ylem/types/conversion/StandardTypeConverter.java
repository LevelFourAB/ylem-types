package se.l4.ylem.types.conversion;

import se.l4.ylem.types.matching.ClassMatchingFastListMultimap;

/**
 * Standard version of {@link TypeConverter}. Supports registering and finding
 * conversions.
 */
public class StandardTypeConverter
	extends AbstractTypeConverter
{

	public StandardTypeConverter()
	{
		super(new ClassMatchingFastListMultimap<>());

		DefaultConversions.register(this::addConversion);
	}
}
