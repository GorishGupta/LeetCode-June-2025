import java.util.*;

public class DS1061 {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, List<Character>> adj = new HashMap<>();
        int n = s1.length();

        // Build the adjacency list
        for (int i = 0; i < n; i++) {
            char u = s1.charAt(i);
            char v = s2.charAt(i);

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        StringBuilder result = new StringBuilder();

        for (char ch : baseStr.toCharArray()) {
            boolean[] visited = new boolean[26];
            char minChar = dfs(adj, ch, visited);
            result.append(minChar);
        }

        return result.toString();
    }

    private char dfs(Map<Character, List<Character>> adj, char ch, boolean[] visited) {
        visited[ch - 'a'] = true;
        char minChar = ch;

        for (char neighbor : adj.getOrDefault(ch, new ArrayList<>())) {
            if (!visited[neighbor - 'a']) {
                char candidate = dfs(adj, neighbor, visited);
                if (candidate < minChar) {
                    minChar = candidate;
                }
            }
        }

        return minChar;
    }

    public static void main(String[] args) {
        DS1061 solution = new DS1061();
        String s1 = "parker";
        String s2 = "morris";
        String baseStr = "parser";

        String result = solution.smallestEquivalentString(s1, s2, baseStr);
        System.out.println("Smallest equivalent string: " + result); // Expected output: "morris"
    }
}
