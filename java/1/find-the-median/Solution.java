import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Solution {
    public static int findMedian(List<Integer> list) {
        Collections.sort(list);

        int mid = list.size() / 2;
        return list.get(mid);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 400, 8000, 900000, 3);
        System.out.println(findMedian(list));
    }
}