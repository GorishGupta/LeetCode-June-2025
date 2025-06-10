class DS1061 {
    int[] parent = new int[26];

    private int findUltPar(int x) {
        if (parent[x] != x) {
            parent[x] = findUltPar(parent[x]);
        }
        return parent[x];
    }

    // Union-Find (Disjoint Set Union) to merge characters
    private void union(int u, int v) {
        int ultPar_u = findUltPar(u);
        int ultPar_v = findUltPar(v);

        if (ultPar_u != ultPar_v) {
            if (ultPar_u < ultPar_v) {
                parent[ultPar_v] = ultPar_u;
            } else {
                parent[ultPar_u] = ultPar_v;
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';

            union(u, v);
        }

        for (int i = 0; i < baseStr.length(); i++) {
            int mappedChar = findUltPar(baseStr.charAt(i) - 'a');
            sb.append((char) (mappedChar + 'a'));
        }

        return sb.toString();
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
