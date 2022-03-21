class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> table = new PriorityQueue<>((a,b) -> b - a);
        for (int x : nums) {
            table.add(x);
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = table.poll();
        }
        return result;
    }
}