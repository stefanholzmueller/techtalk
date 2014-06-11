package java8.annotations;

import java.lang.annotation.Repeatable;

@Repeatable(Authors.class)
public @interface Author {
	String value();
}