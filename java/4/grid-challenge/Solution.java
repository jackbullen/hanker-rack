import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static String gridChallenge(List<String> grid) {
        //  <char[]>
        List<String> sortedRows = grid.stream()
            .map(s -> {
                char[] chars = s.toCharArray(); 
                Arrays.sort(chars);
                return new String(chars);
                //     chars
            })
            .collect(Collectors.toList());

        for (int row = 0; row < grid.size() - 1; row++) {
            for (int col = 0; col < grid.get(0).length(); col++) {
                //                     [col]                                 [col]
                if (sortedRows.get(row).charAt(col) > sortedRows.get(row + 1).charAt(col)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        List<String> grid = Arrays.asList(
            "abcde",
            "fghij",
            "klmno",
            "pqrst",
            "uvwxy"
        );
        System.out.println(gridChallenge(grid));
    }
}