class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < nums.length; i++) {
            sb.setLength(0);
            int index = i;
            while (index + 1 < nums.length && nums[index] + 1 == nums[index + 1]) {
                index++;
            }
            
            if (index == i) {
                sb.append(nums[i]);
            } 
            else {
                sb.append(nums[i]).append('-').append('>').append(nums[index]);
            }
            result.add(sb.toString());
            i = index;
        }
        return result;
    }
    
    // Approach 1
    // public List<String> summaryRanges(int[] nums) {
    //     if (nums == null || nums.length == 0)
    //         return new ArrayList<String>();
    //     List<String> result = new ArrayList<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         int start = nums[i];
    //         while (i + 1 < nums.length && nums[i] + 1 == nums[i+1]) {
    //             i++;
    //         }
    //         if (start != nums[i]) {
    //             result.add("" + start + "->" + nums[i]);
    //         }
    //         else {
    //             result.add("" + start);
    //         }
    //     }
    //     return result;
    // }
}