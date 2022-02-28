class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<String>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i+1]) {
                i++;
            }
            if (start != nums[i]) {
                result.add("" + start + "->" + nums[i]);
            }
            else {
                result.add("" + start);
            }
        }
        return result;
    }
}