public class DS3423 {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int res = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 0; i < n - 1; ++i) {
            res = Math.max(res, Math.abs(nums[i] - nums[i + 1]));
        }
        return res;
    }

    public static void main(String[] args) {
        DS3423 ds3423 = new DS3423();
        int[] nums = { 1, 3, 5, 7, 9 };
        int result = ds3423.maxAdjacentDistance(nums);
        System.out.println("The maximum adjacent distance is: " + result);
    }
}
