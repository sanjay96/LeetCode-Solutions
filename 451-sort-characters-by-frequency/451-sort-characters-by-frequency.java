class Solution {
    public String frequencySort(String s) {
        Map<Character, int[]> table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!table.containsKey(c)) {
                table.put(c, new int[]{1, i});
            }
            else {
                int[] frequencyAndIndex = table.get(c);
                frequencyAndIndex[0]++;
                table.put(c, frequencyAndIndex);
            }
        }
        PriorityQueue<Map.Entry<Character, int[]>> pq = new PriorityQueue<>((a,b) -> a.getValue()[0] == b.getValue()[0] ? a.getValue()[1] - b.getValue()[1] : b.getValue()[0] - a.getValue()[0]);
        
        pq.addAll(table.entrySet());
        
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, int[]> e = pq.poll();
            for (int i = 0; i < e.getValue()[0]; i++ )
                result.append(e.getKey());
        }
        return result.toString();
    }
}