class Solution {
    // Space Optimized
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                result.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return result;
    }
    
    // Brute Force with Memory
    // public List<Integer> findDuplicates(int[] nums) {
        // List<Integer> result = new ArrayList<>();
        // Set<Integer> set = new HashSet<>();
        // for (int x : nums) {
        //     if (set.contains(x)) {
        //         result.add(x);
        //     }
        //     set.add(x);
        // }
        // return result;
    // }
}