class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int n = nums.length;
        int sum = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result = result + preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}