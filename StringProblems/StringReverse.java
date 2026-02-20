package StringProblems;

public class StringReverse {
    public static void main(String[] args) {
        String str = "a3bc";
        str.chars().mapToObj(c->(char)c).filter(c->Character.isDigit(c)).forEach(System.out::println);

    }
}
