module se.l4.ylem.types.mapping {
	requires com.github.spotbugs.annotations;

	requires com.github.benmanes.caffeine;

	requires transitive se.l4.ylem.types.reflect;
	requires se.l4.ylem.types.matching;

	exports se.l4.ylem.types.mapping;
}
