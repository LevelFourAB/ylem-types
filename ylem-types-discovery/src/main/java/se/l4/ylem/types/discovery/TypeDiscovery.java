package se.l4.ylem.types.discovery;

import java.lang.annotation.Annotation;

import org.eclipse.collections.api.set.SetIterable;

import edu.umd.cs.findbugs.annotations.NonNull;
import se.l4.ylem.types.discovery.internal.TypeDiscoveryBuilderImpl;
import se.l4.ylem.types.instances.InstanceFactory;

/**
 * Interface to help discover and load types on the classpath.
 */
public interface TypeDiscovery
{
	/**
	 * Get classes that have been annotated with a certain annotation.
	 *
	 * @param annotationType
	 * @return
	 */
	@NonNull
	SetIterable<Class<?>> getTypesAnnotatedWith(@NonNull Class<? extends Annotation> annotationType);

	/**
	 * Get classes that have the given annotation, automatically creating them.
	 *
	 * @param annotationType
	 * @return
	 */
	@NonNull
	SetIterable<? extends Object> getTypesAnnotatedWithAsInstances(@NonNull Class<? extends Annotation> annotationType);

	/**
	 * Get sub types of the given class.
	 *
	 * @param type
	 * @return
	 */
	@NonNull
	<T> SetIterable<Class<? extends T>> getSubTypesOf(@NonNull Class<T> type);

	/**
	 * Get sub types of the given class automatically creating them.
	 *
	 * @param type
	 * @return
	 */
	@NonNull
	<T> SetIterable<? extends T> getSubTypesAsInstances(@NonNull Class<T> type);

	/**
	 * Return a builder to create an instance of {@link TypeDiscovery}.
	 *
	 * @return
	 *   builder that can be used to configure the finder
	 */
	@NonNull
	static Builder create()
	{
		return new TypeDiscoveryBuilderImpl();
	}

	interface Builder
	{
		/**
		 * Set the instance factory to use.
		 *
		 * @param factory
		 * @return
		 *   self
		 */
		@NonNull
		Builder setInstanceFactory(@NonNull InstanceFactory factory);

		/**
		 * Add a package to scan for types. This will activate scanning for
		 * the package and any subpackages it has.
		 *
		 * @return
		 *   self
		 */
		@NonNull
		Builder addPackage(@NonNull String pkgName);

		/**
		 * Add several packages to scan for types.
		 *
		 * @param pkgs
		 * @return
		 *   self
		 */
		@NonNull
		Builder addPackages(@NonNull Iterable<String> pkgs);

		/**
		 * Create the instance.
		 *
		 * @return
		 */
		@NonNull
		TypeDiscovery build();
	}
}
