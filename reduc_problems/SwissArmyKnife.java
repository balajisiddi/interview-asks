package reduc_problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SwissArmyKnife {
    public static void main(String[] args) {
        List<String> list  = Arrays.asList("Alice", "Bob", "Canon");
        String [] arr= { "David", "Elon", "Neon"};
        String combined = list.stream()
                .reduce(" ", (s1, s2)-> s2+s1);
        System.out.println(combined);
        String strJoined= list.stream()
                .collect(Collectors.joining());
        System.out.println(strJoined);
        String join_string = Arrays.stream(arr)
                .collect(Collectors.joining());
        System.out.println(join_string);
        List<String> filtered_names = list.stream()
                .filter(s-> s.length() == 3)
                .toList();
        System.out.println(filtered_names);
        String reduce_working = list.stream()
                .reduce("->",
                        (partial, next)-> partial + (partial.isEmpty() ? "" : ", ")+next);
        System.out.println(reduce_working);

        String testing_reduce = list.stream()
                .reduce("->",
                        (p,n)-> p + n);







    }
}
