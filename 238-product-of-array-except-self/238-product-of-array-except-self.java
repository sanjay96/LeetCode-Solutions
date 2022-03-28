class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int pre = 1;
        result[0] = 1;
        result[nums.length - 1] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            pre = pre * nums[i-1];
            result[i] = pre;
        }
        pre = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            pre = nums[i + 1] * pre;
            result[i] = pre * result[i];
        }
        return result;
    }
}