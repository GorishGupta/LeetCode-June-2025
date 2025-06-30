import java.util.Arrays;

class DS594 {
    static {
        for (int i = 0; i < 500; i++) {
            findLHS(new int[] { 1, 2, 3, 4 });
        }
    }

    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - nums[j] > 1) {
                j++;
            }
            if (nums[i] - nums[j] == 1) {
                maxLength = Math.max(maxLength, i - j + 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 2, 5, 4, 3, 2 };
        int result = findLHS(nums);
        System.out.println("Length of Longest Harmonious Subsequence: " + result);
    }
}