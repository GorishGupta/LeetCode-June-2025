public class DS440 {
    public int findKthNumber(int n, int k) {
        long ans = 1;
        k--; // Convert k to zero-based index
        for (int i = 1; i < k;) {
            final long gap = getGap(ans, ans + 1, n);
            if (i + gap <= k) {
                i += gap;
                ++ans;
            } else {
                ++i;
                ans *= 10;
            }
        }

        return (int) ans;
    }

    private long getGap(long a, long b, long n) {
        long gap = 0;
        while (a <= n) {
            gap += Math.min(n + 1, b) - a;
            a *= 10;
            b *= 10;
        }
        return gap;
    }

    public static void main(String[] args) {
        DS440 ds440 = new DS440();
        int n = 13; // Example input
        int k = 2; // Example k value
        int result = ds440.findKthNumber(n, k);
        System.out.println("The " + k + "th number in lexical order up to " + n + " is: " + result); // Expected output:
                                                                                                     // 10
    }
}
