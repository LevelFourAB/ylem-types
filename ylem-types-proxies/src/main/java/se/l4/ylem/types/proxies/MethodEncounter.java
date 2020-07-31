package se.l4.ylem.types.proxies;

import se.l4.ylem.types.reflect.MethodRef;

/**
 * An encounter with a method, contains methods to help with creating a
 * {@link MethodInvoker}.
 */
public interface MethodEncounter
{
	/**
	 * Get the method this generation is for.
	 *
	 * @return
	 */
	MethodRef getMethod();
}
