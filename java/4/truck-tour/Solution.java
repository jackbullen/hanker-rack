import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;

public class Solution {
    public static Integer getFuel(List<Integer> pump) {
        return pump.get(0);
    }

    public static Integer getDist(List<Integer> pump) {
        return pump.get(1);
    }

    public static int truckTour(List<List<Integer>> pumps) {
        HashMap<Integer, Integer> currFuel = new HashMap<>();

        List<Integer> curr;
        for (int i = 0; i < pumps.size(); i++) {
            curr = pumps.get(i);
            if (currFuel.size() == 0) {
                currFuel.put(i, getFuel(curr) - getDist(curr));
            } else {
                currFuel.put(i, currFuel.get(i-1) + getFuel(curr) - getDist(curr));
            }
            if (currFuel.get(i) < 0) {
                // Run out of fuel
                currFuel.clear();
            }
        }

        if (currFuel.isEmpty()) {
            return -1;
        } else {
            return Collections.min(currFuel.keySet());
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> pumps = Arrays.asList(
            Arrays.asList(1, 5),
            Arrays.asList(10, 3),
            Arrays.asList(3, 4)
        );
        System.out.println(truckTour(pumps));
    }
}