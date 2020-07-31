module se.l4.ylem.types.instances.guice {
	requires transitive se.l4.ylem.types.instances;

	requires jakarta.inject;
	requires transitive com.google.guice;

	exports se.l4.ylem.types.instances.guice;
}
