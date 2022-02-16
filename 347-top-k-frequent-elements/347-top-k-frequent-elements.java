class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);    
        }
        
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null)
                buckets[frequency] = new ArrayList<Integer>();
            buckets[frequency].add(key);
        }
        
        int[] result = new int[k]; 
        int resultIndex = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) 
                continue;
            for (int num : buckets[i]) {
                result[resultIndex] = num;
                resultIndex = resultIndex + 1;
                if (resultIndex == k) {
                    return result;
                }
            }
        }
        return result;
    }
    
    
    // Using Priority Queue as a Heap
    /*public int[] topKFrequent(int[] nums, int k) {
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
    }*/
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
