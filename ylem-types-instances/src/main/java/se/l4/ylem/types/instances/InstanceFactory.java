package se.l4.ylem.types.instances;

import java.lang.annotation.Annotation;
import java.util.Objects;
import java.util.function.Supplier;

import edu.umd.cs.findbugs.annotations.NonNull;
import se.l4.ylem.types.reflect.TypeRef;

/**
 * Factory for instances, used to support dependency injection if available.
 */
public interface InstanceFactory
{
	/**
	 * Create the specified type.
	 *
	 * @param <T>
	 *   type of class being created
	 * @param type
	 *   the class being created
	 * @return
	 *   instance of the type
	 * @throws InstanceException
	 *   if unable to create the given instance
	 */
	@NonNull
	<T> T create(@NonNull Class<T> type);

	/**
	 * Create the specified generic type.
	 *
	 * @param <T>
	 *   type of class being created
	 * @param type
	 *   the class being created - might include generic information
	 * @return
	 *   instance of the type
	 * @throws InstanceException
	 *   if unable to create the given instance
	 */
	@NonNull
	@SuppressWarnings("unchecked")
	default <T> T create(@NonNull TypeRef type)
	{
		return create((Class<T>) type.getErasedType());
	}

	/**
	 * Create the specified type using the given annotation as hints.
	 *
	 * @param <T>
	 *   type of class being created
	 * @param type
	 *   type being created
	 * @param annotations
	 *   annotations related to the creation of the type, for example the
	 *   annotations provided on a field or in a parameter
	 * @return
	 *   instance of the type
	 * @throws InstanceException
	 *   if unable to create the given instance
	 */
	@NonNull
	default <T> T create(@NonNull TypeRef type, @NonNull Iterable<? extends Annotation> annotations)
	{
		// Default implementation ignores the annotations
		return create(type);
	}

	/**
	 * Create a supplier for instances of the given type.
	 *
	 * @param type
	 *   class that the supplier should create
	 * @return
	 *   supplier that when invoked will create the given type
	 */
	@NonNull
	default <T> Supplier<T> supplier(@NonNull Class<T> type)
	{
		Objects.requireNonNull(type);
		return () -> create(type);
	}

	/**
	 * Create a supplier for instances of the given type.
	 *
	 * @param type
	 *   the type that the supplier should create
	 * @return
	 *   supplier that when invoked will create the given type
	 */
	@NonNull
	default <T> Supplier<T> supplier(@NonNull TypeRef type)
	{
		Objects.requireNonNull(type);
		return () -> create(type);
	}

	/**
	 * Create a supplier for instances of the given type using the
	 * annotations as hints.
	 *
	 * @param type
	 *   the type that the supplier should create
	 * @param annotations
	 *   the annotations to use as hints
	 * @return
	 *   supplier that will create the type based on the type and annotations
	 */
	@NonNull
	default <T> Supplier<T> supplier(@NonNull TypeRef type, @NonNull Iterable<? extends Annotation> annotations)
	{
		Objects.requireNonNull(type);
		Objects.requireNonNull(annotations);
		return () -> create(type, annotations);
	}
}
