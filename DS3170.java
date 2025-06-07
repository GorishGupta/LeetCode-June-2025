import java.util.*;

public class DS3170 {
    public String clearStars(String s) {
        ArrayList<ArrayList<Integer>> charIndices = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            charIndices.add(new ArrayList<>());
        boolean[] removed = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                for (int j = 0; j < 26; j++) {
                    if (!charIndices.get(j).isEmpty()) {
                        int lastIndex = charIndices.get(j).size() - 1;
                        int removeIndex = charIndices.get(j).get(lastIndex);
                        removed[removeIndex] = true;
                        charIndices.get(j).remove(lastIndex);
                        break;
                    }
                }
            } else
                charIndices.get(ch - 'a').add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != '*' && !removed[i])
                sb.append(s.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        DS3170 solution = new DS3170();
        String s = "ab*c*d*e";
        String result = solution.clearStars(s);
        System.out.println("Result: " + result); // Expected output: "ae"
    }
}
