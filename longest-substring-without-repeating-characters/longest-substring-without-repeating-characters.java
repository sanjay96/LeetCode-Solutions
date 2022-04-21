class Solution {
    //Array as Hashtable
    // public int lengthOfLongestSubstring(String s) {
    //     int[] table = new int[256];
    //     Arrays.fill(table, -1);
    //     int start = 0, res = 0, x = 0, n = s.length();
    //     for(int i = 0; i < n; i++) {
    //         x = s.charAt(i);
    //         start = Math.max(start, table[x] + 1);
    //         res = Math.max(res, i - start + 1);
    //         table[x] = i;
    //     }
    //     return res;
    // }
    
    // public int lengthOfLongestSubstring(String s) {
    //     int max = 0;
    //     var map = new HashMap<Character, Integer>();
    //     for (int i = 0, j = 0; i < s.length(); i++) {
    //         if (map.containsKey(s.charAt(i))) {
    //             j = Math.max(j, map.get(s.charAt(i)) + 1);
    //         }
    //         map.put(s.charAt(i), i);
    //         max = Math.max(max, i - j + 1);
    //     }
    //     return max;
    // }
    
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        int[] table = new int[128];
        while (right < s.length()) {
            char r = s.charAt(right);
            int i = table[r];
            if (i >= 1 && i >= left)
                left = i;
            result = Math.max(result, right - left + 1);
            
            table[r] = ++right;
        }
        return result;
    }
    
    
}