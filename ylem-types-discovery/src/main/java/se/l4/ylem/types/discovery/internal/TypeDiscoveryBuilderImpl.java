package se.l4.ylem.types.discovery.internal;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import se.l4.ylem.types.discovery.TypeDiscovery;
import se.l4.ylem.types.instances.DefaultInstanceFactory;
import se.l4.ylem.types.instances.InstanceFactory;

/**
 * Builder for {@link TypeDiscoveryImpl}.
 */
public class TypeDiscoveryBuilderImpl
	implements TypeDiscovery.Builder
{
	private InstanceFactory factory;
	private Set<String> packages;

	public TypeDiscoveryBuilderImpl()
	{
		factory = new DefaultInstanceFactory();
		packages = new HashSet<>();
	}

	@Override
	public TypeDiscovery.Builder setInstanceFactory(InstanceFactory factory)
	{
		Objects.requireNonNull(factory);

		this.factory = factory;
		return this;
	}

	@Override
	public TypeDiscovery.Builder addPackage(String pkgName)
	{
		Objects.requireNonNull(pkgName);

		packages.add(pkgName);
		return this;
	}

	@Override
	public TypeDiscovery.Builder addPackages(Iterable<String> pkgs)
	{
		Objects.requireNonNull(pkgs);

		for(String pkg : pkgs)
		{
			packages.add(pkg);
		}
		return this;
	}

	@Override
	public TypeDiscovery build()
	{
		ScanResult result = new ClassGraph()
			.enableAnnotationInfo()
			.enableClassInfo()
			.acceptPackages(packages.toArray(new String[packages.size()]))
			.scan();

		return new TypeDiscoveryImpl(factory, result);
	}

}
