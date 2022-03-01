class Solution {
    //DP Bottom Up
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) offset = i;
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }
    
    //Brute Force
    // public int[] countBits(int n) {
    //     int[] result = new int[n+1];
    //     int count = 0;
    //     int temp = 0;
    //     for (int i = n; i >= 0; i--) {
    //         count = 0;
    //         temp = i;
    //         while (temp != 0) {
    //             count = count + (temp % 2);
    //             temp = temp / 2;
    //         }
    //         result[i] = count;
    //     }
    //     return result;
    // }
}
