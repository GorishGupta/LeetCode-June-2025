public class DS2138 {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groups = (n + k - 1) / k;
        String[] result = new String[groups];

        for (int i = 0; i < groups; i++) {
            StringBuilder group = new StringBuilder();
            for (int j = 0; j < k; j++) {
                int index = i * k + j;
                if (index < n) {
                    group.append(s.charAt(index));
                } else {
                    group.append(fill); // Padding
                }
            }
            result[i] = group.toString();
        }

        return result;
    }
}

public static void main(String[] args) {
    DS2138 solution = new DS2138();
    String s = "abcdefghi";
    int k = 3;
    char fill = 'x';
    String[] result = solution.divideString(s, k, fill);
    for (String str : result) {
        System.out.println(str);
    }
}
