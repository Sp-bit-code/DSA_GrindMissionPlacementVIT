
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i;
            int fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                slow = next(nums, slow, forward);
                if (slow == -1) break;

                fast = next(nums, fast, forward);
                if (fast == -1) break;

                fast = next(nums, fast, forward);
                if (fast == -1) break;

                if (slow == fast) {
                    return true;
                }
            }

            // Mark visited indices as 0
            int current = i;
            while (nums[current] != 0 &&
                   (nums[current] > 0) == forward) {
                int nextIndex = next(nums, current, forward);
                nums[current] = 0;

                if (nextIndex == -1) break;
                current = nextIndex;
            }
        }

        return false;
    }

    private int next(int[] nums, int i, boolean forward) {
        int n = nums.length;

        // All steps must have the same direction
        if (nums[i] == 0 || (nums[i] > 0) != forward) {
            return -1;
        }

        // Handle positive and negative circular jumps
        int nextIndex = ((i + nums[i]) % n + n) % n;

        // A self-loop is not valid
        if (nextIndex == i) {
            return -1;
        }

        return nextIndex;
    }
}
