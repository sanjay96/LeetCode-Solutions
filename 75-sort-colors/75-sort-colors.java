class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int num : nums) {
            if (num == 0) 
                red++;
            else if (num == 1)
                white++;
            else
                blue++;
        }
        int i = 0;
        while (i < nums.length) {
            if (red > 0) {
                nums[i] = 0;
                red--;
            }
            else if (white > 0) {
                nums[i] = 1;
                white--;
            }
            else {
                nums[i] = 2;
                blue--;
            }
            i++;
        }
    }
}