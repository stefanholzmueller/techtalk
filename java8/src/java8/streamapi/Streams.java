package java8.streamapi;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("movies.list"),
				Charset.defaultCharset());
		long startTime = System.currentTimeMillis();
		double result = avgWordLength(lines);
		long endTime = System.currentTimeMillis();
		System.out.println(result + " (after " + (endTime - startTime) + "ms)");
	}

	// map/reduce
	// lazy
	// parallel = fork/join
	// primitive specialization
	// option type
	private static double avgWordLength(List<String> lines) {
		Stream<String> stream = lines.parallelStream();
		Stream<String> words = stream.flatMap(l -> Stream.of(l.split("\\s+")));
		IntStream lengths = words.mapToInt(String::length);
		OptionalDouble average = lengths.average();
		return average.getAsDouble();
	}
}
