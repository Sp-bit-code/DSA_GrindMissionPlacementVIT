
class Solution {
    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // Skip non-vowels from left
            if (!isVowel(arr[left])) {
                left++;
            }

            // Skip non-vowels from right
            else if (!isVowel(arr[right])) {
                right--;
            }

            // Swap vowels
            else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        return new String(arr);
    }

    public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
