class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0)
            return new int[0][0];
        int low = 0, high = points.length - 1;
        while (low < high) {
            int index = quickselect(points, low, high);
            
            if (index == k) {
                break;
            }
            else if (index < k) {
                low = index + 1;
            }
            else {
                high = index - 1;
            }
        }
        
        return Arrays.copyOf(points, k);
    }
    
    
    private int quickselect(int[][] points, int low, int high) {
        int index = low, pivot = high;
        
        int pivotDistance = distance(points[pivot]);
        
        for (int i = low; i < high; i++) {
            if (distance(points[i]) < pivotDistance) {
                swap(points, i, index);
                index++;
            }
        }
        swap(points, index, pivot);
        return index;
    }
    
    private int distance(int[] pair) {
        return pair[0] * pair[0] + pair[1] * pair[1];
    }
    
    private void swap(int[][] points, int low, int high) {
        int[] temp = points[low];
        points[low] = points[high];
        points[high] = temp;
    }
    
    //Using a Heap
//     private int dis(int[] point) {
//         return point[0] * point[0] + point[1] * point[1];
//     }
    
//     public int[][] kClosest(int[][] points, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
//             return dis(points[i2]) - dis(points[i1]);
//         });
        
//         for (int i = 0; i < points.length; i++) {
//             pq.add(i);
//             if (pq.size() > k) {
//                 pq.remove();
//             }
//         }
        
//         int[][] result = new int[k][2];
//         for (int i = 0; i < k; i++) {
//             int index = pq.poll();
//             result[i] = points[index];
//         }
//         return result;
//     }
}