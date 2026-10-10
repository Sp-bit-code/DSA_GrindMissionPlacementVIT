
class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        // Step 1: Calculate sum of first k elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Step 2: Slide the window
        for (int i = k; i < nums.length; i++) {

            sum = sum + nums[i] - nums[i - k];

            maxSum = Math.max(maxSum, sum);
        }

        // Step 3: Return maximum average
        return (double) maxSum / k;
    }
}
