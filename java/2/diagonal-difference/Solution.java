import java.lang.Math;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Solution {
    public static int diagonalDifferenceSimple(List<List<Integer>> arr) {
        int out = 0;
        int n = arr.size();
        for (int i=0; i < n; i++) {
            out += arr.get(i).get(i) - arr.get(n - 1 - i).get(i);
        }
        return Math.abs(out);
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        return Math.abs(IntStream.range(0, n)
            .map(i -> arr.get(i).get(i) - arr.get(n - 1 - i).get(i))
            .sum());
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(
            Arrays.asList(1,2,3),
            Arrays.asList(4,5,6),
            Arrays.asList(7,8,9)
        );
        System.out.println(diagonalDifference(arr));
    }
}