class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n-1] = questions[n-1][0];
        for (int i = n - 2; i >= 0; i--) {
            int range = questions[i][1] + 1;
            long sum = 0;
            if (i + range < n) {
                int j = i + range;
                sum += dp[j];
            }
            dp[i] = Math.max(questions[i][0] + sum, dp[i + 1]); 
        }
        
        return dp[0];
    }
}
