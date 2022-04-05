class Solution {
    public int maxArea(int[] height) {
        int maxArea=0;
        int area=0;
        int i =0;
        int j = height.length - 1;
        while(i < j){
            if(height[i] > height[j]){
                area = height[j] * (j-i);
                j--;
            } else {
                area = height[i] * (j-i);
                i++;
            }
            if(area > maxArea) maxArea = area;
        }
        return maxArea;
    }
    
    // 2 pointer Greedy
    // public int maxArea(int[] height) {
    //     int i = 0, j = height.length - 1;
    //     int max = 0;
    //     while (i < j) {
    //         max = Math.max(max,Math.min(height[i], height[j]) * (j-i));
    //         if (height[i] > height[j]) j--;
    //         else i++;
    //     }
    //     return max;
    // }
    
    // Brute Force
    // public int maxArea(int[] height) {
    //     int i = 0, n = height.length - 1;
    //     int max = 0;
    //     for (i = 0; i < n; i++) {
    //         for (int j = i+1; j <= n; j++)
    //         max = Math.max(max, Math.min(height[i], height[j]) * (j-i));
    //     }
    //     return max;
    // }
}