class Solution {
    public int lastStoneWeight(int[] stones) {
        // int result = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        for (int stone : stones) {
            heap.add(stone);
        }
        while (true) {
            int one = heap.poll();
            if (heap.size() == 0)
                return one;
            else {
                int two = heap.poll();
                heap.offer(Math.abs(one - two));
            }
        }
    }
}