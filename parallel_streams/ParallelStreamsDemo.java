package parallel_streams;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamsDemo {
	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1,2,3,4,5);
		l1.stream()//sequencial streams
		.map(n-> n*n)
		.forEach(System.out::println);
		
		l1.parallelStream().map(n->n*n).forEach(System.out::println);
		
	
	}
}
