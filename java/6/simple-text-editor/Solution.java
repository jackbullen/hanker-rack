import java.util.Stack;
import java.util.Scanner;

public class Solution {
    private static String S = "";
    private static Stack<String> history = new Stack<>();

    private static void append(String W) {
        history.push(S);
        S += W;
    }

    private static void delete(int k) {
        history.push(S);
        S = S.substring(0, S.length() - k);
    }

    private static void pprint(int k) {
        System.out.println(S.charAt(k - 1));
    }

    private static void undo() {
        S = history.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOps = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numOps; i++) {
            String[] op = scanner.nextLine().split(" ");
            int operation = Integer.parseInt(op[0]);

            if (operation == 1) {
                append(op[1]);
            } else if (operation == 2) {
                delete(Integer.parseInt(op[1]));
            } else if (operation == 3) {
                pprint(Integer.parseInt(op[1]));
            } else if (operation == 4) {
                undo();
            }
        }

        scanner.close();
    }
}