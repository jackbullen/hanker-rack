public class Solution {
    public static boolean isPalindrome(String s) {
        int st = 0;
        int ed = s.length() - 1;
        while (st <= ed) {
            if (s.charAt(st) != s.charAt(ed)) {
                return false;
            }
            st++;
            ed--;
        }
        return true;
    }

    public static int palindromeIndex(String s) {
        if (isPalindrome(s)) return -1;

        int st = 0;
        int ed = s.length() - 1;
        while (st <= ed) {
            if (isPalindrome(s.substring(st+1, ed+1))) return st;
            if (isPalindrome(s.substring(st, ed))) return ed;
            st++;
            ed--;
        }
        // No possible palindromes
        return -1; 
    }

    public static void main(String[] args) {
        String test1 = "fvyqxqxynewuebtcuqdwyetyqqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqyvf";
        System.out.println(palindromeIndex(test1));
    }
}