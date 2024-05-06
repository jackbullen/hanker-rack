import java.math.BigInteger;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {
    public static int legoBlocks(int ht, int wd) {
        BigInteger modulo = BigInteger.valueOf((int)Math.pow(10, 9) + 7);

        // Generate the list containing number of possible arrangements at ground
        List<BigInteger> numBase = new ArrayList<>(
            Arrays.asList(
                BigInteger.valueOf(1), 
                BigInteger.valueOf(2), 
                BigInteger.valueOf(4), 
                BigInteger.valueOf(8)
        ));
        if (wd > 4) {
            for (int i = 4; i < wd; i++) {
                numBase.add((numBase.get(i-1)
                             .add(numBase.get(i-2))  
                             .add(numBase.get(i-3))
                             .add(numBase.get(i-4)))
                            .mod(modulo)
                );
            }
        }

        // Compute number of arrangements at increasing heights
        List<BigInteger> g = new ArrayList<>();
        for (int i = 0; i < numBase.size(); i++) {
            g.add(numBase.get(i).modPow(BigInteger.valueOf(ht), modulo));
        }

        // Populate the list of num possible walls up to desired height
        List<BigInteger> h = new ArrayList<>(Arrays.asList(BigInteger.ONE));
        for (int i = 2; i < wd+1; i++) {
            BigInteger toRemove = BigInteger.ZERO;
            for (int j = 0; j < h.size(); j++) {
                toRemove = toRemove.add(h.get(j).multiply(g.get(h.size()-1-j)));
            }
            h.add(((g.get(i-1).subtract(toRemove)).mod(modulo)));
        }

        return h.get(h.size() - 1).intValue();
    }

    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            Scanner scanner = new Scanner(file);

            int numCases = scanner.nextInt();

            for (int i = 0; i < numCases; i++) {
                int ht = scanner.nextInt();
                int wd = scanner.nextInt(); 
                System.out.println(legoBlocks(ht, wd));
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}