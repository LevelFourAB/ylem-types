module se.l4.ylem.types.conversion {
	requires com.github.spotbugs.annotations;

	requires transitive org.eclipse.collections.api;
	requires org.eclipse.collections.impl;

	requires com.github.benmanes.caffeine;

	requires se.l4.ylem.types.matching;
	requires se.l4.ylem.types.reflect;

	exports se.l4.ylem.types.conversion;
}
