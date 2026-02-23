package StringProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;


final class Student{
	private final Long id;
	private final String name;
	private Student(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}

class Vehicle {
	private static final Vehicle INSTANCE = new Vehicle(5L, "Car");
	private Long id;
	private String name;
	
	private Vehicle(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public static Vehicle getInstance() {
		return INSTANCE;
	}
	public Long getId(){
		return id;
	}
	public String getName() {
		return name;
	}
}
record Employee(Long id, String name) {
	
}

public class CharCount {
	
	public static void main(String[] args) {
		String str ="programming";
		String hello= "Hello hello world World java Java";
		Map<Character, Integer> charCount= new HashMap<>();
		for(char c: str.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0)+1);
		}
		for(Map.Entry<Character, Integer> entry: charCount.entrySet()) {
			if(entry.getValue() > 1) {
				System.out.println(entry.getKey() + " appears " + entry.getValue() + " times");
			}
		}
		
		charCount.entrySet().forEach(entry-> System.out.println(entry.getValue()));
		Map<Character, Long> repeats = new HashMap<Character, Long>();
		repeats = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()));
		repeats.forEach((k,v)->{
			if(v>1) System.out.println(k+":"+v);
		});
		
		charCount.forEach((k,v)->{
			if(v > 1) {
				System.out.println(k+":"+v);
			}
		});
		
		for(char c: str.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0)+1);
		}
		
		String[] words= hello.split(" ");
		
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		for(String word: words) {
			wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
		}
		wordCount.entrySet().stream()
		.forEach(System.out::println);
		
		Map<String, Integer> caseWordCount= new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		for(String word: words) {
			caseWordCount.put(word, caseWordCount.getOrDefault(word, 0)+1);
		}
		caseWordCount.entrySet().stream()
		.forEach(System.out::println);
		
		Map<String, Long> wordCounting = Arrays.stream(hello.split(" "))
		.collect(Collectors.groupingBy(word->word, ()->new TreeMap<>(String.CASE_INSENSITIVE_ORDER), Collectors.counting())); 
		wordCounting.entrySet().forEach(System.out::println);
		
		wordCount.forEach((k, v)-> {
			System.out.println(k+" +++ "+ v);
		});
		
		for(Map.Entry<String, Long> entry: wordCounting.entrySet()) {
			System.out.println(entry.getKey()+"---"+entry.getValue());
		}
		
		wordCounting.entrySet().stream().forEach(e->System.out.println(e.getKey()+"==="+e.getValue()));
		for(String key: wordCounting.keySet()) {
			System.out.println("The Key"+key);
		}
		for(Long value: wordCounting.values()) {
			System.out.println("The Value::"+value);
		}
		
		Iterator<Map.Entry<String, Long>> iterator = wordCounting.entrySet().iterator();
		
		while(iterator.hasNext()) {
			Map.Entry<String, Long> entry = iterator.next();
			System.out.println(entry.getKey()+"****"+entry.getValue());
		}
		
		String s="java programMing";
		Map<String, Long> charCounts = Arrays.stream(s.split(""))
				.collect(Collectors.groupingBy(ch->ch, ()->new TreeMap<String, Long>(String.CASE_INSENSITIVE_ORDER), Collectors.counting()));
		Iterator<Map.Entry<String, Long>> charIterator= charCounts.entrySet().iterator();
		while(charIterator.hasNext()) {
			Map.Entry<String, Long> entry= charIterator.next();
			System.out.println(entry.getKey()+"||||"+entry.getValue());
		}
		
		for(Integer value: charCount.values()) {
			System.out.println(value);
		}
		
		for(char key: charCount.keySet()) {
			System.out.println(key);
		}
		
		charCount.entrySet().stream().forEach(e->System.out.println(e.getKey()+"===="+e.getValue()));
		
		for(Map.Entry<String, Long> entry: charCounts.entrySet()) {
			System.out.println(entry.getKey()+"---"+entry.getValue());
		}
		
		charCounts.forEach((k,v)->{
			System.out.println(k+"%%%"+v);
		});
		
		List<String> fruits = Arrays.asList("Banana", "Apple", "Orange", "Grapes", "Kiwi");
		Collections.sort(fruits);
		System.out.println(fruits);
		Collections.sort(fruits, Collections.reverseOrder());
		System.out.println(fruits);
		fruits.stream().filter(fruit-> fruit.startsWith("a")).forEach(System.out::println);
		
	}

}
