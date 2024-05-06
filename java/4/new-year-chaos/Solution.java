import java.lang.Math;
import java.util.List;
import java.util.Arrays;

public class Solution {
    public static void minimumBribes(List<Integer> queue) {
        int ct = 0;
        for (int i = 0; i < queue.size(); i ++) {
            int curr = queue.get(i);
            if (curr - (i+1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, curr-2); j < i; j++) {
                if (queue.get(j) > curr) {
                    // Looking back find something greater implies bribe
                    ct++;
                }
            }
        }
        System.out.println(ct);
    }

    public static void main(String[] args) {
        List<Integer> t1 = Arrays.asList(2, 1, 5, 3, 4);
        minimumBribes(t1);
        List<Integer> t2 = Arrays.asList(2, 5, 1, 3, 4);
        minimumBribes(t2);
    }
}