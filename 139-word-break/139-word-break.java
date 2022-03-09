class Solution {
    // Using Depth First Search
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] visited = new boolean[n];
        return dfs(0, s, visited, wordDict);
    }
    
    public boolean dfs(int index, String s, boolean[] visited, List<String> wordDict) {
        int n = s.length();
        if (index == n)
            return true;
        if (visited[index] == true) 
            return false;
        visited[index] = true;
        for (String t : wordDict) {
            if (s.startsWith(t, index)) {
                if (dfs(index + t.length(), s, visited, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // Using Dynamic Programming
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     int n = s.length();
    //     boolean[] dp = new boolean[n+1];
    //     dp[n] = true;
    //     for (int i = n - 1; i >= 0; i--) {
    //         for (String w : wordDict) {
    //             if ((i + w.length()) <= n && s.substring(i, i + w.length()).equals(w)) {
    //                 dp[i] = dp[i + w.length()];
    //             }
    //             if (dp[i] == true)
    //                 break;
    //         }
    //     }
    //     return dp[0];
    // }
}
