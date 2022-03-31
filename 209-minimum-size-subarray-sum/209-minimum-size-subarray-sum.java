class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0, result = n + 1;
        for (int j = 0; j < n; j++) {
            target = target - nums[j];
            while (target <= 0) {
                result = Math.min(result, j - i + 1);
                target = target + nums[i];
                i++;
            }
        }
        return result % (n + 1);
    }
}
