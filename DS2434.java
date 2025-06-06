import java.util.*;

public class DS2434 {
    public String robotWithString(String s) {
        int n = s.length();
        char[] prefixMin = new char[n + 1];
        prefixMin[n] = Character.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            prefixMin[i] = (char) Math.min(s.charAt(i), prefixMin[i + 1]);
        }

        StringBuilder res = new StringBuilder(n);
        Deque<Character> t = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            Character c = s.charAt(i);
            t.push(c);
            while (!t.isEmpty() && t.peek() <= prefixMin[i + 1]) {
                res.append(t.pop());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DS2434 solution = new DS2434();
        String s = "zza";
        String result = solution.robotWithString(s);
        System.out.println("Result: " + result); // Expected output: "azz"
    }
}
