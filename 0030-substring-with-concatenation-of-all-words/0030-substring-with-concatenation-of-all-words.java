class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        int wordLen = words[0].length();
        int totalWords = words.length;

        HashMap<String, Integer> required = new HashMap<>();

        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        // Different possible starting offsets
        for (int start = 0; start < wordLen; start++) {

            int left = start;
            int right = start;
            int count = 0;

            HashMap<String, Integer> window = new HashMap<>();

            while (right + wordLen <= s.length()) {

                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // Valid word
                if (required.containsKey(word)) {

                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    // Too many copies of this word
                    while (window.get(word) > required.get(word)) {

                        String leftWord =
                            s.substring(left, left + wordLen);

                        window.put(leftWord,
                                   window.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                    // Found all words
                    if (count == totalWords) {
                        ans.add(left);

                        String leftWord =
                            s.substring(left, left + wordLen);

                        window.put(leftWord,
                                   window.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                } else {

                    // Invalid word → reset window
                    window.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return ans;
    }
}