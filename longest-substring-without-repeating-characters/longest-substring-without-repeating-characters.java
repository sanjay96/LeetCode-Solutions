class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int result = 0;
        int[] table = new int[128];
        
        while (right < n) {
            char r = s.charAt(right);
            
            int i = table[r];
            
            if (i >= 1 && i >= left) {
                left = i;
            }
            
            result = Math.max(result, right - left + 1);
            table[r] = ++right;
        }
        return result;
        
    }
}