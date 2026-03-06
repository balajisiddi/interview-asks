package collections_king;

import java.util.*;

public class SequentialCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("second", "third"));
        list.addFirst("First");
        list.addLast("fourth");
        System.out.println("collection"+ list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        for(String s: list.reversed())
            System.out.println(s+" ");
        list.removeLast();
        System.out.println("Removed Last"+ list);
//        the same sequencial collections with LinkedHashSet
        SequencedSet<String> sequencial_linkedHashSet = new LinkedHashSet<>(Arrays.asList("Two", "Three"));
        sequencial_linkedHashSet.addFirst("One");
        System.out.println(sequencial_linkedHashSet);
    }
}
