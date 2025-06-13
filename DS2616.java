import java.util.Arrays;

public class DS2616 {
    class Solution {
        public int minimizeMax(int[] nums, int p) {
            if (p == 0)
                return 0;
            Arrays.sort(nums);
            int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
            while (left < right) {
                int mid = left + (right - left) / 2, pairs = 0;
                for (int i = 1; i < n; i++) {
                    if (nums[i] - nums[i - 1] <= mid) {
                        pairs++;
                        i++;
                    }
                }
                if (pairs >= p)
                    right = mid;
                else
                    left = mid + 1;
            }
            return left;
        }

        public static void main(String[] args) {
            DS2616 ds2616 = new DS2616();
            Solution solution = ds2616.new Solution();
            int[] nums = { 1, 3, 6, 19, 20 };
            int p = 2;
            int result = solution.minimizeMax(nums, p);
            System.out.println("The minimized maximum distance is: " + result);
        }
    }
}
