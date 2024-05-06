import java.util.stream.Collectors;

public class Solution {
    public static final String alp = "abcdefghijklmnopqrstuvwxyz";

    public static String caesarCipher(String message, int k) {
        return message.chars()
            .mapToObj(c -> (char) c)
            .map(c -> {
                int idx = alp.indexOf(Character.toLowerCase(c));
                char newChar = idx != -1 ? alp.charAt((idx + k) % 26) : c;
                return Character.isUpperCase(c) ? Character.toUpperCase(newChar) : newChar;
            })
            .map(String::valueOf)
            .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String message = "Hi Bob!";
        System.out.println(caesarCipher(message, 3));
    }
}