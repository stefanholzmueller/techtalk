package java8.functionalinterfaces;

import java.util.function.Function;
import java.util.function.Predicate;

public class Overloaded {

	<T, R> void print(Function<T, R> f) {
		System.out.println(f.apply(null));
	}

	<T> void print(Predicate<T> p) {
		System.out.println(p.test(null));
	}

	public static void main(String[] args) {
		// new Overloaded().print(x -> true);
	}
}
