class Solution {
    // Using priority queue
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int[] row : matrix) {
            for (int x : row) {
                heap.add(x);
            }
        }
        int answer = 0;
        while (k-- > 0) {
            answer = heap.poll();
        }
        return answer;
    }
}
