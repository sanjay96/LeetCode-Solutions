class Solution {
    public int majorityElement(int[] nums) {
        int max = 0, result = 0;
        Map<Integer, Integer> table = new HashMap<>();
        for (int num: nums) {
            table.put(num, table.getOrDefault(num, 0) + 1);
            if (max < table.get(num)) {
                max = table.getOrDefault(num, 0);
                result = num;
            }
        }
        return result;
    }
}
