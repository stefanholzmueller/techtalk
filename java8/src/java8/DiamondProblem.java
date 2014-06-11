package java8;

public class DiamondProblem {

	interface A {
		void print();
	}

	interface B extends A {
		default void print() {
			System.out.println("B");
		}
	}

	interface C extends A {
		default void print() {
			System.out.println("C");
		}

		static void printFoo() {
			System.out.println("foo");
		}
	}

	static class D implements B, C {
		public void print() {
			C.super.print();
		}
	}

	public static void main(String[] args) {
		new D().print();
	}

}
