class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 2) {
            if (target == nums[0] || target == nums[1])
                return true;
            return false;
        }
        int left = 0, right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target || nums[right] == target || nums[left] == target)
                return true;
            
            // Right is sorted
            if (nums[mid] < nums[right]) {
                if (target > nums[right] || target < nums[mid]) {
                    right = mid - 1;
                }
                else if (target > nums[mid]) {
                    left = mid + 1;
                }
            }
            
            // Left half is sorted
            else if (nums[mid] > nums[left]){
                if (target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                }
                else if (target < nums[mid]) {
                    right = mid - 1;
                }
            }
            else {
                right--;
            }
            
            
        }
        return false;
        
    }
}