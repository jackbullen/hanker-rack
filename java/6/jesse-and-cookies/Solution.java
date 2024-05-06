import java.util.List;
import java.util.ArrayList;
// import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {
    public static int cookies(int k, List<Integer> list) {
        PriorityQueue<Integer> q = new PriorityQueue<>(list);
        int ops = 0;
        while (true) {
            int x = q.poll();
            if (x >= k) {
                return ops;
            } else if (q.isEmpty()) {
                return -1;
            }
            int y = q.poll();
            q.add(x + 2*y);
            ops++;
        }
    }

    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            Scanner scanner = new Scanner(file);
            int numCookies = scanner.nextInt();
            int threshold = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i< numCookies; i++) {
                list.add(scanner.nextInt());
            }
            System.out.println(cookies(threshold, list));
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}

// Sort call everytime is too slow O(n^2).
// Instead use a min heap O(nlogn).
// public static int cookies(int k, List<Integer> list) {
//     Collections.sort(list);
//     int ops = 0;
//     while (true) {
//         int x = list.remove(0);
//         if (x >= k) {
//             return ops;
//         } else if (list.isEmpty()) {
//             return -1;
//         }
//         int y = list.remove(0);
//         list.add(x + 2*y);
//         Collections.sort(list);
//         ops++;
//     }
// }