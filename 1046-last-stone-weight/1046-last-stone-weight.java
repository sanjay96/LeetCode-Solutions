class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        
        while (n > 1) {
            Arrays.sort(stones);
            stones[n-2] = stones[n-1] - stones[n-2];
            n--;
        }
        return stones[0];
    }
    
    // Heap
    // public int lastStoneWeight(int[] stones) {
    //     PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
    //     for (int stone : stones) {
    //         heap.add(stone);
    //     }
    //     while (true) {
    //         int one = heap.poll();
    //         if (heap.size() == 0)
    //             return one;
    //         else {
    //             int two = heap.poll();
    //             heap.offer(Math.abs(one - two));
    //         }
    //     }
    // }
}
