package se.l4.ylem.types.matching;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.list.ListIterable;

import edu.umd.cs.findbugs.annotations.NonNull;
import se.l4.ylem.types.reflect.TypeRef;

/**
 * Specialized map to associated classes and interfaces with data. This map
 * supports matching against the type hierarchy to fetch data.
 */
public interface TypeMatchingMultimap<D>
{
	/**
	 * Get data directly associated with the given type.
	 *
	 * @param type
	 *   the type get data for
	 * @return
	 *   optional containing data if there is direct match or empty optional
	 */
	@NonNull
	ListIterable<D> get(@NonNull TypeRef type);

	/**
	 * Get all types and their associated data matching the given type.
	 *
	 * @param type
	 *   the type to match against
	 * @return
	 *   list of matching entries. The list will be empty if no matches are
	 *   available.
	 */
	@NonNull
	ListIterable<MatchedTypeRef<D>> getAll(@NonNull TypeRef type);

	/**
	 * Get all of the entries in this map without doing any matching.
	 *
	 * @return
	 *   immutable list of all entries registered
	 */
	RichIterable<MatchedTypeRef<D>> entries();

	/**
	 * Get an immutable version of this map.
	 *
	 * @return
	 */
	TypeMatchingMultimap<D> toImmutable();

	/**
	 * Get a mutable copy of this map.
	 *
	 * @return
	 */
	MutableTypeMatchingMultimap<D> toMutable();
}
