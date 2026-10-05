import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // frequency of p
        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            windowFreq[s.charAt(right) - 'a']++;

            // keep window size equal to p.length()
            if (right - left + 1 > p.length()) {
                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }

            // compare frequencies
            if (right - left + 1 == p.length()
                    && Arrays.equals(pFreq, windowFreq)) {
                ans.add(left);
            }
        }

        return ans;
    }
}