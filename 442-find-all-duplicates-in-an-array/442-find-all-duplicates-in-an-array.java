class Solution {
    // Brute Force with Memory
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                result.add(x);
            }
            set.add(x);
        }
        return result;
    }
}