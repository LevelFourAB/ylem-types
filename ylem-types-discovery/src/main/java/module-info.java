module se.l4.ylem.types.discovery {
	requires com.github.spotbugs.annotations;

	requires transitive org.eclipse.collections.api;
	requires org.eclipse.collections.impl;

	requires io.github.classgraph;

	requires transitive se.l4.ylem.types.instances;

	exports se.l4.ylem.types.discovery;
}
