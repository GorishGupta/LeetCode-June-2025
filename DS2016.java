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

    }
}