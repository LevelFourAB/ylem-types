package se.l4.ylem.types.reflect.internal;

import java.lang.reflect.Type;
import java.util.Optional;

import se.l4.ylem.types.reflect.TypeRef;
import se.l4.ylem.types.reflect.TypeUsage;

public class ArrayTypeRef
	extends TypeRefImpl
{
	private final TypeRef componentType;

	ArrayTypeRef(
		Type type,
		TypeRefBindings typeBindings,
		TypeUsage typeUsage,
		TypeRef componentType
	)
	{
		super(type, typeBindings, typeUsage);

		this.componentType = componentType;
	}

	@Override
	public Optional<TypeRef> getComponentType()
	{
		return Optional.of(componentType);
	}

	@Override
	public boolean equals(Object obj)
	{
		if(! (obj instanceof ArrayTypeRef))
		{
			return false;
		}

		return super.equals(obj);
	}
}
