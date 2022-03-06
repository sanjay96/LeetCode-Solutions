class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 0;
        
        Set<Integer> set = new HashSet<>();
        for (int x : nums) 
            set.add(x);
        
        int currentStreak = 0;
        int longestStreak = 0;
        
        for (int num : set) {
            if (!set.contains(num + 1)) {
                while (set.contains(num)) {
                    currentStreak++;
                    num--;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
                currentStreak = 0;
            }
        }
        return longestStreak;
    }
}

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if (nums == null || nums.length == 0) 
//             return 0;
//         Set<Integer> set = new HashSet<>();
        
//         for (int x : nums) 
//             set.add(x);
        
//         int count = 0;
//         int longestSequence = 0;
        
//         for (int i = 0; i < nums.length; i++) {
//             //Check if the number is the start of the sequence
//             if (set.contains(nums[i]-1)) 
//                 continue;
//             else {
//                 count = 1;
//                 while (set.contains(nums[i] + count))
//                     count++;
//                 longestSequence = Math.max(longestSequence, count);
//             }
//         }
//         return longestSequence;
//     }
// }