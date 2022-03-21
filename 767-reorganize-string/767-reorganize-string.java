class Solution {
    
    public String reorganizeString(String s) {
        int[] table = new int[26];
        int max = 0, letter = 0;
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            if (table[s.charAt(i) - 'a'] > max) {
                max = table[s.charAt(i) - 'a'];
                letter = s.charAt(i) - 'a';
            }
        }
        if (max > (s.length() + 1) / 2)
            return "";
        
        char[] result = new char[s.length()];
        
        int index = 0;
        while (table[letter] > 0) {
            result[index] = (char) (letter + 'a');
            index += 2;
            table[letter]--;
        }
        for (int i = 0; i < table.length; i++) {
            while (table[i] > 0) {
                if (index >= result.length) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                index = index + 2;
                table[i]--;
            }
        }
        return String.valueOf(result);
    }
    
    
    //Using Priority Queue
//     public String reorganizeString(String s) {
//         Map<Character, Integer> map = new HashMap<>();
//         for (char c : s.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//             if (map.get(c) > (s.length() + 1) / 2)
//                 return "";
//         }
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
//         for (char c : map.keySet()) {
//             pq.add(new int[] {c, map.get(c)});
//         }
        
//         StringBuilder result = new StringBuilder();
//         while (!pq.isEmpty()) {
//             int[] first = pq.poll();
//             if (result.length() == 0 || first[0] != result.charAt(result.length() - 1)) {
//                 result.append((char) first[0]);
//                 if (--first[1] > 0) {
//                     pq.add(first);
//                 }
//             }
//             else {
//                 int[] second = pq.poll();
//                 result.append((char) second[0]);
//                 if (--second[1] > 0) {
//                     pq.add(second);
//                 }
//                 pq.add(first);
//             }
            
//         }
//         return result.toString();
//     }
}
