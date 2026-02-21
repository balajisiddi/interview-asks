package ArrayProblems;

import java.util.Arrays;
import java.util.Collections;

public class ReversingArray {
	
	public static void SortAndSwap(Integer[] arr) {
		System.out.println(arr.length/2);
		Arrays.sort(arr);
		for(int i=0; i< arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		System.out.println("--------------");
		for(int n: arr) {
			System.out.println(n);
		}
	}
	public static void SortAndSwap1(Integer[] arr) {		
		Arrays.sort(arr);
		Arrays.stream(arr).forEach(System.out::println);
		for(int i=0; i< arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
	
	@SuppressWarnings("unused")
	public static void SortAndSwap2(int[] arr) {
		int[] sorted = Arrays.stream(arr).boxed().sorted((a,b)-> b-a).mapToInt(Integer::intValue).toArray();
	}
	
	public static void main(String[] args) {
		
		Integer[] arr= { 5, 2, 23, 90, 34, 109, 12, 67 };
		int[] arr2= { 1,2,3,4,5};
		int[] arr3 = {5,1,2,3,4};
		char[] arr4 = {'a', 'b', 'c', 'd'};
		Character[] arr5 = {'d', 'c', 'b', 'a', 'e' };
		ReversingArray.SortAndSwap1(arr);
		ReversingArray.SortAndSwap(arr);
		Arrays.sort(arr);
		
		Arrays.sort(arr,  Collections.reverseOrder());
		for(int el: arr) {
			System.out.println(el);
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		Arrays.stream(arr2).boxed().sorted(Collections.reverseOrder()).forEach(System.out::println);
		Arrays.stream(arr).sorted().forEach(System.out::println);
		Arrays.stream(arr3).boxed().sorted(Collections.reverseOrder()).forEach(System.out::print);
		System.out.println("Even elements only...");
		Arrays.stream(arr3).boxed().sorted(Collections.reverseOrder()).filter(n-> n%2!=0).forEach(System.out::print);
		Arrays.sort(arr4);
		for(int i=0; i< arr4.length/2; i++) {
			char temp = arr4[i];
			arr4[i] = arr4[arr4.length-1-i];
			arr4[arr4.length-1-i] = temp;
		}
		
		Arrays.stream(arr5).sorted().forEach(System.out::print);
		
	}

}
