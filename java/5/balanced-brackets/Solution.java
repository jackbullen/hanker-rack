import java.util.List;
import java.util.Stack;
import java.util.HashMap;

public class Solution {
    public static HashMap<Character, Character> openToClose = new HashMap<>();
    static {
        openToClose.put('[', ']');
        openToClose.put('(', ')');
        openToClose.put('{', '}');
    }

    public static String isBalanced(String s) {
        Stack<Character> brackets = new Stack<>();

        char curr; 
        for (int i = 0; i < s.length(); i++) {
            curr = s.charAt(i);
            if (openToClose.containsKey(curr)) {
                brackets.push(curr);
            } else if (openToClose.containsValue(curr)) {
                if (brackets.isEmpty() || openToClose.get(brackets.pop()) != curr){
                    return "NO";
                }
            } 
        }
        return brackets.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        String t1 = "public class Solution {\n" +
                        "public static String isBalanced(String s) {}\n" +
                        "public static void main(String[] args) {}\n" +
                    '}';
        System.out.println(isBalanced(t1));
    }
}