import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class Solution {
    public static int flippingMatrixSimple(List<List<Integer>> arr) {
        int n = arr.size() / 2;

        int tally = 0;
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                List<Integer> numbers = Arrays.asList(
                    arr.get(i).get(j),
                    arr.get(i).get(2*n-1-j),
                    arr.get(2*n-1-i).get(j),
                    arr.get(2*n-1-i).get(2*n-1-j)
                );
                tally += Collections.max(numbers);
            }
        }
        return tally;
    }

    public static int flippingMatrix(List<List<Integer>> arr) {
        int n = arr.size() / 2;

        return IntStream.range(0, n)
            .flatMap(i -> IntStream.range(0, n)
                .map(j -> Collections.max(Arrays.asList(
                    arr.get(i).get(j),
                    arr.get(i).get(2*n-1-j),
                    arr.get(2*n-1-i).get(j),
                    arr.get(2*n-1-i).get(2*n-1-j)
                ))))
            .sum();
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(
            Arrays.asList(1,  2,  3,  4),
            Arrays.asList(5,  6,  7,  8),
            Arrays.asList(9,  10, 11, 12),
            Arrays.asList(13, 14, 15, 16)
        );
        System.out.println(flippingMatrix(arr));
    }
}