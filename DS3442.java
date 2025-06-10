public class DS3442 {
    public int maxDifference(String s) {
        int[] mpp = new int[26];
        int maxi = 0, mini = s.length();
        for (char c : s.toCharArray()) {
            mpp[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (mpp[i] % 2 != 0) {
                maxi = Math.max(maxi, mpp[i]);
            }
            if (mpp[i] % 2 == 0 && mpp[i] > 0) {
                mini = Math.min(mini, mpp[i]);
            }
        }
        return maxi - mini;
    }

    public static void main(String[] args) {
        DS3442 ds3442 = new DS3442();
        String s = "abccba";
        int result = ds3442.maxDifference(s);
        System.out.println("The maximum difference is: " + result);
    }
}
