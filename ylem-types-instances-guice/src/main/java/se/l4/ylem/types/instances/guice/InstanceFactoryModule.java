package se.l4.ylem.types.instances.guice;

import com.google.inject.AbstractModule;

import se.l4.ylem.types.instances.InstanceFactory;

/**
 * Module that binds up a singleton version of {@link InstanceFactory} that
 * will use {@link com.google.inject.Injector} to create instances.
 */
public class InstanceFactoryModule
	extends AbstractModule
{
	@Override
	public void configure()
	{
		bind(InstanceFactory.class).to(GuiceInstanceFactory.class);
	}
}
