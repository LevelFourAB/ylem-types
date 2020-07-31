package se.l4.ylem.types.reflect;

import java.lang.reflect.Type;

import edu.umd.cs.findbugs.annotations.NonNull;
import se.l4.ylem.types.reflect.internal.Primitives;
import se.l4.ylem.types.reflect.internal.TypeHelperImpl;

/**
 * Helpers and utilities related to working with types.
 */
public class Types
{
	private Types()
	{
	}

	@NonNull
	public static TypeRef reference(@NonNull Type type, @NonNull Type... typeParameters)
	{
		return TypeHelperImpl.reference(type, typeParameters);
	}

	/**
	 * Wrap the given class if it's a primitive, will return the same class if
	 * not a primitive.
	 *
	 * @param type
	 * @return
	 */
	public static Class<?> wrap(Class<?> type)
	{
		return Primitives.wrap(type);
	}

	/**
	 * Unwrap the given class if it's a wrapped primitive, will return the same
	 * class if not a primitive.
	 *
	 * @param type
	 * @return
	 */
	public static Class<?> unwrap(Class<?> type)
	{
		return Primitives.unwrap(type);
	}

	/**
	 * Get the default value for the given type.
	 *
	 * @param type
	 * @return
	 */
	public static Object defaultValue(Class<?> type)
	{
		return Primitives.defaultValue(type);
	}
}
