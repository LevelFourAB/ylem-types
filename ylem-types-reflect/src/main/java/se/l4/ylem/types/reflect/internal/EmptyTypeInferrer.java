package se.l4.ylem.types.reflect.internal;

import java.util.Optional;

import se.l4.ylem.types.reflect.TypeInferrer;
import se.l4.ylem.types.reflect.TypeRef;

/**
 * {@link TypeInferrer} that doesn't infer anything.
 */
public class EmptyTypeInferrer
	implements TypeInferrer
{
	public static final TypeInferrer INSTANCE = new EmptyTypeInferrer();

	private EmptyTypeInferrer()
	{
	}

	@Override
	public Optional<TypeRef> infer(TypeRef... types)
	{
		return Optional.empty();
	}
}
