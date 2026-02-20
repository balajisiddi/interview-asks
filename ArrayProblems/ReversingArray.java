package ArrayProblems;

import java.util.Arrays;
import java.util.Collections;

public class ReversingArray {
	
	public static void main(String[] args) {
		Integer[] arr= { 34, 21, 5, 1, 6,76, 33, 1 };
		Arrays.sort(arr,  Collections.reverseOrder());
		for(int el: arr) {
			System.out.println(el);
		}
	}

}
