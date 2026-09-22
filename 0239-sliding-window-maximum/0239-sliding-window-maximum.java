import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            // 1. Remove index which is outside the window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Remove smaller elements from back
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // 3. Add current index
            dq.offerLast(i);

            // 4. Window is ready
            if (i >= k - 1) {
                ans[index++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}