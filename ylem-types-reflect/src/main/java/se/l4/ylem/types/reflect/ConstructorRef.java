package se.l4.ylem.types.reflect;

import java.lang.reflect.Constructor;

/**
 * Reference to a {@link Constructor}.
 */
public interface ConstructorRef
	extends ExecutableRef
{
	/**
	 * Get the constructor this is a reference to.
	 *
	 * @return
	 */
	Constructor<?> getConstructor();
}
