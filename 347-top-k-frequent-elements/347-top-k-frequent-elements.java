class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Integer> l = new ArrayList<>();
        map.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(a -> l.add(a.getKey()));
        int[] answer = new int[k];
        for (int i = 0; i < k; i++)
            answer[i] = l.get(i);
        return answer;
    }
//     public int[] topKFrequent(int[] nums, int k) {
//         var map = new HashMap<Integer, Integer>();
//         for (int x : nums) {
//             map.put(x, map.getOrDefault(x, 0) + 1);
//         }
//         List<Integer> result = new ArrayList<>();
//         for (int x : map.keySet()) {
//             if (map.get(x) >= k) result.add(x);
//         }
//         int[] answer = new int[result.size()];
        
//         for (int i = 0;  i < result.size(); i++) {
//             answer[i] = result.get(i);    
//         }
//         return answer;
//     }
}