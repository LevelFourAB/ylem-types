package se.l4.ylem.types.reflect;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Optional;

import org.junit.jupiter.api.Test;

@SuppressWarnings("all")
public class MethodRefTest
{
	@Test
	public void testReturnType()
	{
		class Test
		{
			public String get() { return null; }
		}

		TypeRef type = Types.reference(Test.class);
		MethodRef method = type.getMethod("get").get();
		assertThat(method.getReturnType().getErasedType(), is((Object) String.class));
	}

	@Test
	public void testGenericReturnType()
	{
		class Test
		{
			public Optional<String> get() { return null; }
		}

		TypeRef type = Types.reference(Test.class);
		MethodRef method = type.getMethod("get").get();

		TypeRef returnType = method.getReturnType();
		assertThat(returnType.getErasedType(), is((Object) Optional.class));

		assertThat(returnType.getTypeParameter(0).get().getErasedType(), is((Object) String.class));
	}

	@Test
	public void testReturnTypeAnnotated()
	{
		class Test
		{
			@TestAnnotation
			public String get() { return null; }
		}

		TypeRef type = Types.reference(Test.class);
		MethodRef method = type.getMethod("get").get();
		assertThat("method has annotation", method.hasAnnotation(TestAnnotation.class), is(true));

		TypeRef returnType = method.getReturnType();
		assertThat("erased type is String", returnType.getErasedType(), is((Object) String.class));
		assertThat("return type has annotation", returnType.getUsage().hasAnnotation(TestAnnotation.class), is(true));
	}

	@Test
	public void testFindIn()
	{
		class A
		{
			Object m(String a)
			{
				return "";
			}
		}

		class B extends A
		{
			@Override
			String m(String a)
			{
				return "";
			}
		}

		TypeRef type = Types.reference(A.class);
		MethodRef inA = type.getDeclaredMethodViaClassParameters("m", String.class).get();

		MethodRef inB = inA.findIn(Types.reference(B.class), TypeSpecificity.MORE).get();

		MethodRef inA2 = inB.findIn(type, TypeSpecificity.LESS).get();
	}

	@Retention(RetentionPolicy.RUNTIME)
	public static @interface TestAnnotation
	{

	}

}
