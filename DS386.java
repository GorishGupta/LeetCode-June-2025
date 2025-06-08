import java.util.*;

public class DS386 {
    static public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            solve(i, n, ans);
        return ans;
    }

    static void solve(int prod, int n, List<Integer> ans) {
        if (prod > n)
            return;
        ans.add(prod);
        for (int j = 0; j < 10; j++) {
            int next = prod * 10 + j;
            if (next > n)
                return;
            solve(next, n, ans);
        }
    }

    public static void main(String[] args) {
        int n = 13; // Example input
        List<Integer> result = lexicalOrder(n);
        System.out.println("Lexical order up to " + n + ": " + result); // Expected output: [1, 10, 11, 12, 13, 2, 3, 4,
                                                                        // 5, 6, 7, 8, 9]
    }
}
