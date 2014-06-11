package java8.annotations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

//@Authors({ @Author("alice"), @Author("bob") })
@Author("alice")
@Author("bob")
class Foo {

	List<@NonNull String> list = new ArrayList<>();

}
