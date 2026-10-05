import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // If number already exists in current window
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            // Keep only last k elements
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}