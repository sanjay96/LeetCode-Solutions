class Solution {
    private int dis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
            return dis(points[i2]) - dis(points[i1]);
        });
        
        for (int i = 0; i < points.length; i++) {
            pq.add(i);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int index = pq.poll();
            result[i] = points[index];
        }
        return result;
    }
}