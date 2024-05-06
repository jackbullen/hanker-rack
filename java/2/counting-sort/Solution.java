import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Solution {
    public static List<Integer> countingSort(List<Integer> list) {
        List<Integer> out = Stream.generate(() -> 0).limit(100)
                                .collect(Collectors.toList());
        
        list.forEach(i -> out.set(i, out.get(i) + 1));

        return out;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 2, 5);
        System.out.println(countingSort(list));
    }
}