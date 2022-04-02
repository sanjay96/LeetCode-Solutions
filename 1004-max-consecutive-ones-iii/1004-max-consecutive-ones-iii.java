class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int count = 0;
        int result = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] == 0) {
                count++;
            }
            while (count > k && i < n) {
                if (nums[i] == 0)
                    count--;
                i++;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}