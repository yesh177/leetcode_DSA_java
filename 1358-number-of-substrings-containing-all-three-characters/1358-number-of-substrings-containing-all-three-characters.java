class Solution {
    public int numberOfSubstrings(String s) {

        int n = s.length();

        int[] freq = new int[3];

        int left = 0;
        int count = 0;

        for (int right = 0; right < n; right++) {

            // Add current character
            freq[s.charAt(right) - 'a']++;

            // Window contains a, b and c
            while (freq[0] > 0 &&
                   freq[1] > 0 &&
                   freq[2] > 0) {

                // All substrings ending from right to n-1
                // are also valid
                count += n - right;

                // Remove left character
                freq[s.charAt(left) - 'a']--;

                left++;
            }
        }

        return count;
    }
}