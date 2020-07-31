package se.l4.ylem.types.mapping;

import edu.umd.cs.findbugs.annotations.NonNull;
import se.l4.ylem.types.reflect.TypeRef;

/**
 * Encounter used by {@link Resolver}.
 */
public interface ResolutionEncounter<O>
{
	/**
	 * Get the type being resolved.
	 *
	 * @return
	 */
	@NonNull
	TypeRef getType();
}
