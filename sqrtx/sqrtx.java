class Solution {
    public int mySqrt(int target) {
        if (target == 0 || target == 1) return target;
        int left = 1, right = target - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == target / mid)
                return mid;
            else if (mid < target / mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }
}