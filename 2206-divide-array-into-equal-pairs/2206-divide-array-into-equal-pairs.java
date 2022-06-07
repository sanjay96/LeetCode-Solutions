class Solution {
    public boolean divideArray(int[] nums) {
        int[] table = new int[1001];
        for (int num : nums)
            table[num]++;
        for (int num : nums)
            if (table[num] % 2 != 0)
                return false;
        return true;
    }
}