import java.util.Arrays;

class DS2966 {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[i / 3] = new int[] { nums[i], nums[i + 1], nums[i + 2] };
        }
        return ans;
    }

    public static void main(String[] args) {
        DS2966 solution = new DS2966();
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        int k = 2;
        int[][] result = solution.divideArray(nums, k);
        if (result.length == 0) {
            System.out.println("No valid division possible.");
        } else {
            for (int[] group : result) {
                System.out.println(Arrays.toString(group));
            }
        }
    }
}