package se.l4.ylem.types.reflect.internal;

import java.lang.reflect.TypeVariable;
import java.util.Optional;

import org.eclipse.collections.api.list.ListIterable;

import se.l4.ylem.types.reflect.TypeInferrer;
import se.l4.ylem.types.reflect.TypeRef;

/**
 * {@link TypeInferrer} that infers a type based on a pattern type and some
 * concrete types.
 */
public class TypeParameterInferrer
	implements TypeInferrer
{
	private final TypeRef patternType;
	private final TypeVariable<?>[] variables;

	public TypeParameterInferrer(TypeRef patternType, ListIterable<TypeVariable<?>> variables)
	{
		this.patternType = patternType;
		this.variables = variables.toArray(new TypeVariable[variables.size()]);
	}

	@Override
	public Optional<TypeRef> infer(TypeRef... types)
	{
		if(variables.length != types.length)
		{
			return Optional.empty();
		}

		return modify(patternType, types);
	}

	public Optional<TypeRef> modify(TypeRef pattern, TypeRef[] typesToBind)
	{
		if(pattern.getType() instanceof TypeVariable<?>)
		{
			// This should be replaced with a new binding
			TypeVariable<?> tv = ((TypeVariable<?>) pattern.getType());
			String name = tv.getName();
			for(int i=0, n=typesToBind.length; i<n; i++)
			{
				if(name.equals(variables[i].getName()))
				{
					return Optional.of(
						typesToBind[i].mergeWithUsage(pattern.getUsage())
					);
				}
			}

			return TypeHelperImpl.findCommon(tv.getBounds())
				.map(t -> TypeHelperImpl.reference(t));
		}
		else
		{
			TypeRef modifiedType = pattern;

			ListIterable<TypeRef> parameters = pattern.getTypeParameters();
			for(int i=0, n=parameters.size(); i<n; i++)
			{
				TypeRef parameter = parameters.get(i);
				Optional<TypeRef> modified = modify(parameter, typesToBind);

				if(! modified.isPresent())
				{
					return Optional.empty();
				}

				TypeRef m = modified.get();
				if(m != parameter)
				{
					// Type has been modified somehow, rebind the type parameter
					Optional<TypeRef> modification = modifiedType.withTypeParameter(i, m);
					if(! modification.isPresent())
					{
						return Optional.empty();
					}

					modifiedType = modification.get();
				}
			}

			return Optional.of(modifiedType);
		}
	}
}
