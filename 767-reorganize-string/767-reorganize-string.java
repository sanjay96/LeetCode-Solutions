class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > (s.length() + 1) / 2)
                return "";
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.add(new int[] {c, map.get(c)});
        }
        
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (result.length() == 0 || first[0] != result.charAt(result.length() - 1)) {
                result.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            }
            else {
                int[] second = pq.poll();
                result.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
            
        }
        return result.toString();
    }
}
