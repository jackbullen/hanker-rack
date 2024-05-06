import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    public static int lonelyInteger(List<Integer> list) {
        List<Integer> possible = new ArrayList<>();
        for (int num : list) {
            if (possible.contains(num)) {
                possible.remove(Integer.valueOf(num));
            } else {
                possible.add(num);
            }
        }
        return possible.get(0);
    }

    public static int lonelyInteger429(List<Integer> list) {
        int result = 0;
        for (int num : list) {
            result ^= num;
        }
        return result; 
    }

    public static int lonelyInteger330429(List<Integer> list) {
        return list.stream().reduce(0, (a, b) -> a ^ b);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 1, 2, 8, 3, 5, 8, 3);
        System.out.println(lonelyInteger330429(list));
    }
}