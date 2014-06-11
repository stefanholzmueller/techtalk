package java8.functionalinterfaces;

import java.util.function.Function;

public class Closures {
	public static void main(String[] args) {
		int x = 1;
		// x = 2;
		Function<String, String> closure = str -> str + x;
		print(closure);
	}

	static void print(Function<String, String> closure) {
		String asd1 = closure.apply("asd");
		System.out.println(asd1);
	}
}
