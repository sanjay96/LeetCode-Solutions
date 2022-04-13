class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    private int atMost(int[] nums, int goal) {
        if (goal < 0) 
            return 0;
        int result = 0;
        int n = nums.length;
        int i = 0;
        for (int j = 0; j < n; j++) {
            goal = goal - nums[j];
            while (goal < 0) {
                goal = goal + nums[i];
                i++;
            }
            result = result + j - i + 1;
        }
        return result;
    }
}