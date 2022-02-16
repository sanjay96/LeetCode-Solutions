class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if (k == nums.length) {
            return nums;
        }
        
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
          count.put(n, count.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2));

        for (int n: count.keySet()) {
          heap.add(n);
          if (heap.size() > k) 
              heap.poll();    
        }

        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;  
    }
    
    // Using a HashMap
    // public int[] topKFrequent(int[] nums, int k) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int x : nums) {
    //         map.put(x, map.getOrDefault(x, 0) + 1);
    //     }
    //     List<Integer> frequencyList = new ArrayList<>();
    //     map.entrySet().stream()
    //             .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
    //             .forEach(a -> frequencyList.add(a.getKey()));
    //     int[] answer = new int[k];
    //     for (int i = 0; i < k; i++)
    //         answer[i] = frequencyList.get(i);
    //     return answer;
    // }
}
