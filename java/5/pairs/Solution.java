import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static int pairs(int k, List<Integer> numbers) {
        // Create a counter HashMap
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : numbers) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int total = 0;
        for (int num : numbers) {
            // Increment by count if k = x - num
            total += counter.getOrDefault(num + k, 0);
        }
        return total;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(pairs(3, numbers));
    }
}