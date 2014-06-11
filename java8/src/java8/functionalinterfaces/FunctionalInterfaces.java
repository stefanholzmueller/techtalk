package java8.functionalinterfaces;

import java.awt.event.ActionEvent;

public interface FunctionalInterfaces {

	interface ActionListener {
		void actionPerformed(ActionEvent e);
	}

	interface Function<T, R> {
		R apply(T t);
	}

	interface Runnable {
		void run();
	}

	interface Predicate<T> {
		boolean test(T t);
	}

	interface Supplier<T> {
		T get();
	}

	interface IntBinaryOperator {
		int applyAsInt(int left, int right);
	}

}
