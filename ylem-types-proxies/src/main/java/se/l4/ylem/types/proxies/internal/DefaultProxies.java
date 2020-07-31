package se.l4.ylem.types.proxies.internal;

import se.l4.ylem.types.proxies.ExtendedTypeBuilder;
import se.l4.ylem.types.proxies.Proxies;

/**
 * Default implementation of {@link Proxies}.
 */
public class DefaultProxies
	implements Proxies
{
	public DefaultProxies()
	{
	}

	@Override
	public <ContextType> ExtendedTypeBuilder<ContextType> newExtendedType(Class<ContextType> type)
	{
		return new ExtendedTypeBuilderImpl<>(type);
	}

}
