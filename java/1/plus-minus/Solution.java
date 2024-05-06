import java.util.*;

public class Solution {
    public static void plusMinus(List<Integer> list) {
        int pos = 0;
        int neg = 0;
        int zer = 0;
        for (Integer num : list) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            } else {
                zer++;
            }
        }
        double ratioPos = (double) pos/list.size();
        double ratioNeg = (double) neg/list.size();
        double ratioZer = (double) zer/list.size();
        System.out.println(String.format("%.6f\n%.6f\n%.6f", ratioPos, ratioNeg, ratioZer));
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, -1, 0, 0);
        plusMinus(list);
    }
}