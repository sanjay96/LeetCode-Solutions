class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersection(nums2, nums1);
        }
        Set<Integer> result = new HashSet<>();
        Arrays.sort(nums2);
        for (int x : nums1) {
            if (binarySearch(nums2, x)) {
                result.add(x);
            }
        }
        int[] answer = new int[result.size()];
        int i = 0;
        for (int x : result) {
            answer[i++] = x;
        }
        return answer;
    }
    
    private boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid < nums.length && nums[mid] == target)
                return true;
            else if (mid < nums.length && nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}