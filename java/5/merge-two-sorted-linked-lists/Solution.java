import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {

    public static LinkedList mergeLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> merged = new LinkedList<>();
        merged.addAll(l1);
        merged.addAll(l2);
        Collections.sort(merged);
        return merged;
    }

    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            int numCases = scanner.nextInt();

            // Read in lists and call mergeLists
            for (int i = 0; i < numCases; i++) {
                int listLength = scanner.nextInt();

                LinkedList<Integer> list1 = new LinkedList<>();
                for (int j = 0; j < listLength; j++) {
                    list1.add(scanner.nextInt());
                }

                listLength = scanner.nextInt();

                LinkedList<Integer> list2 = new LinkedList<>();
                for (int j = 0; j < listLength; j++) {
                    list2.add(scanner.nextInt());
                }

                System.out.println(mergeLists(list1, list2));
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}