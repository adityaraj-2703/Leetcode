package streams;

import java.util.Arrays;
import java.util.List;

public class StreamConcepts {
    public static void main(String[] args) {
        List<String> al = Arrays.asList("a", "b", "c", "d", "e");
        // al.stream().forEach(System.out::println);
        al.stream().filter(s -> (int) s.charAt(0) < 99).forEach(System.out::println);
        al.stream().map(s -> "This is " + s).forEach(System.out::println);
        List<Integer> al1 = Arrays.asList(45, 13, 67, 98, 34, 12, 2, 44, 33, 1, 9);
        al1.stream().sorted().forEach(System.out::println);
        System.out.println("-----------------");
        al1.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);

    }

}
