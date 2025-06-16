class DS2016 {
    public int maximumDifference(int[] nums) {
        int minValue = nums[0];
        int maxDifference = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minValue) {
                maxDifference = Math.max(maxDifference, nums[i] - minValue);
            }
            minValue = Math.min(minValue, nums[i]); // Update the minimum
        }

        return maxDifference;
    }

    public static void main(String[] args) {
        DS2016 solution = new DS2016();
        int[] nums = { 7, 1, 5, 4, 6, 3 };
        System.out.println("Maximum Difference: " + solution.maximumDifference(nums)); // Output: 5
    }
}