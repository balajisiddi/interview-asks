package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReversingArray {
	
	public static void sortStrings(String[] arr) {
		
		Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
	}
	
	public static void caseSensitiveProblem(char[] arr) {
		String str = new String(arr);
		String[] split = str.split("");
		Arrays.sort(split, String.CASE_INSENSITIVE_ORDER);
	}
	
	public static void streamSorting(Character[] boxed) {
		Arrays.sort(boxed, (a,b)->{
			boolean aDigit = Character.isDigit(a);
			boolean bDigit = Character.isDigit(b);
			if(aDigit!=bDigit) {
				return aDigit ? 1 : -1;
			}
			return a-b;
		});
		for(char c: boxed) {
			System.out.println("Sorted-Streams: "+c);
		}
	}
	
	public static void partitionDigits(char[] arr) {
		int left =0;
		int right = arr.length -1;
		while(left < right) {
			while(left < right && !Character.isDigit(arr[left])) left ++;
			while(left < right && Character.isDigit(arr[right])) right --;
			if(left < right) {
				char temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		
		/*
		 * lenght =4
		 * left = 0
		 * right = 4-1 = 3
		 * 0<3	true
		 * 0<3 =true  && numbers[0] = 'b' true so true left++ = 1
		 * 1<3 = true && numbers[1] = 'd' true so true left++ =2
		 * 2<3 = true && numbers[2] = '5' false so false come out of the loop
		 * 2<3 = true && numbers[3] = 'e' fale so false exit 
		 * 2<3 true temp = numbers[2] = 5 
		 * numbers[2] = numbers[3]  numbers = b,d,e,e
		 * numbers[3] tem = 5 numbers = b,d,e,5
		 * 2<3 true
		 * 
		 *  
		 */
	}
	
	public static void SortAndSwap(Integer[] arr) {
		char[] numbers= { 'b', 'd', '5', 'e'};
		ReversingArray.partitionDigits(numbers);
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
		System.out.println(arr4.length+" the length");
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
		Arrays.sort(arr5, Collections.reverseOrder());
		
		for(char ch: arr5) {
			System.out.println(ch);
		}
		
		Arrays.sort(arr5, Collections.reverseOrder());
		char[] arr6 = { 'a', '5', '4', 'b', 'e', '3', 'd', '2', 'c', '1'};
		
		char[] result = new char[arr6.length];
		int index =0;
		for(char c: arr6) {
			if(!Character.isDigit(c)) {
				result[index++] = c;
			}
		}
		for(char c: arr6) {
			if(Character.isDigit(c)) {
				result[index++] = c;
			}
		}
		
		for(char c: result) {
			System.out.println("moved Numbers: "+c);
		}
		
		
		for(char c: arr6) {
			System.out.println("found-sorted:: "+c);
		}
		
		Character[] boxed= {'3', 'a', '1', 'b', '2'};
		ReversingArray.streamSorting(boxed);
		
		String[]  sArr= {"HeMan", "hello", "Hello", "World", "world"};
		Arrays.sort(sArr, String.CASE_INSENSITIVE_ORDER);
		for(String s: sArr) {
			System.out.println("SortedString: "+s);
		}
		
		String str="h3110";
		int sum =0;
		char[] chars= str.toCharArray();
		List<Integer> foundInts= new ArrayList<>();
		for(char c: chars) {
			if(Character.isDigit(c)) {
				foundInts.add(Character.getNumericValue(c));
				sum += Character.getNumericValue(c);
			}
		}
		System.out.println(sum);
		Collections.sort(foundInts);
		for(int i: foundInts) {
			System.out.println("Trend--"+i);
		}
		
		char[] combination = {'c', '5', 'b', 'e', 'd', 'a'};
		Arrays.sort(combination);
		for(char c: combination) {
			System.out.println("----"+c);
		}
		
		
		
		
	}

}
