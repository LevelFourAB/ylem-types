module se.l4.ylem.types.proxies {
	requires com.github.spotbugs.annotations;

	requires transitive org.eclipse.collections.api;
	requires org.eclipse.collections.impl;
	requires net.bytebuddy;

	requires transitive se.l4.ylem.types.reflect;

	exports se.l4.ylem.types.proxies;
}
