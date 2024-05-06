import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        File file = new File("input.txt");
        try {
            Scanner scanner = new Scanner(file);
            int numQueries = scanner.nextInt();
            for (int i = 0; i < numQueries; i++) {
                int query = scanner.nextInt();
                switch (query) {
                    case 1 -> queue.push(scanner.nextInt());
                    case 2 -> queue.pop();
                    case 3 -> System.out.println(queue.peek());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

    }
}