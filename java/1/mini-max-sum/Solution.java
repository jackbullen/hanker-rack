import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    public static void miniMaxSum(List<Integer> list){
        Collections.sort(list);

        long minSum = list.stream().limit(4).mapToLong(Integer::longValue).sum();
        long maxSum = list.stream().skip(1).mapToLong(Integer::longValue).sum();

        System.out.println(minSum + " " + maxSum);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625);
        miniMaxSum(list);
    }
}