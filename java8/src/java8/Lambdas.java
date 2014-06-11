package java8;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Lambdas {

	private static List<String> list;

	@Before
	public void setUp() {
		list = new ArrayList<String>();
		list.add("");
		list.add("a");
		list.add("b");
		list.add("");
		list.add("c");
	}

	@After
	public void tearDown() {
		assertThat(list, is(Arrays.asList("a", "b", "c")));
	}

	@Test
	public void testIterator() {
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String str = iterator.next();
			if (str.isEmpty()) {
				iterator.remove();
			}
		}
	}

	private void removeIf(Collection<String> coll, Predicate<String> pred) {
		for (Iterator<String> iterator = coll.iterator(); iterator.hasNext();) {
			String str = iterator.next();
			if (pred.test(str)) {
				iterator.remove();
			}
		}
	}

	// interface Predicate<T> {
	// boolean test(T t);
	// }

	@Test
	public void testPredicate() {
		removeIf(list, new Predicate<String>() {
			@Override
			public boolean test(String str) {
				return str.isEmpty();
			}
		});
	}

	// Java 8
	@Test
	public void testLambda1() {
		removeIf(list, (String str) -> {
			return str.isEmpty();
		});
	}

	@Test
	public void testLambda2() {
		removeIf(list, str -> {
			return str.isEmpty();
		});
	}

	@Test
	public void testLambda3() {
		removeIf(list, str -> str.isEmpty());
	}

	@Test
	public void testMethodReference() {
		removeIf(list, String::isEmpty);
	}

	@Test
	public void testStandard() {
		list.removeIf(String::isEmpty);
	}

	// type inference
	// return fehlt
	// block syntax
	// primitive interfaces
	// functional interfaces
	// invokedynamic
	// strategy pattern
}
