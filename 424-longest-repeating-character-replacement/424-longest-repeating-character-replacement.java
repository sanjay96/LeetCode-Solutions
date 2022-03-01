class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] table = new int[26];
        int start = 0; 
        int maxLength = 0;
        int maxCount = 0;
        for (int end = 0; end < n; end++) {
            table[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, table[s.charAt(end) - 'A']);
            while (end - start + 1  - maxCount > k) {
                table[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}