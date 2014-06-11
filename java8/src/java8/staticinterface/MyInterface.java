package java8.staticinterface;

public interface MyInterface {
	static MyInterface unit() {
		return null;
	}

	public class MyClass implements MyInterface {

	}
}
