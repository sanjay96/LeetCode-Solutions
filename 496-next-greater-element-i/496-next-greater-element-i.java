class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            table.put(nums1[i], i);
        }
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            int current = nums2[i];
            while (!stack.isEmpty() && current > stack.peek()) {
                int val = stack.pop();
                int valIndex = table.get(val);
                result[valIndex] = current;
            }
            if (table.containsKey(current)) {
                stack.push(current);
            }
        }
        return result;
    }
}