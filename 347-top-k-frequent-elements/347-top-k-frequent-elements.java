class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Integer> frequencyList = new ArrayList<>();
        map.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(a -> frequencyList.add(a.getKey()));
        int[] answer = new int[k];
        for (int i = 0; i < k; i++)
            answer[i] = frequencyList.get(i);
        return answer;
    }
}
