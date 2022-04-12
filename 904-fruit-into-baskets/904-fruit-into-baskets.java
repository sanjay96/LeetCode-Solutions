class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n <= 2) 
            return n; 
        int l = 0;
        int r = -1;
        int fruitCount = 0;       
        for (int i = 1; i < n; i++) {
            if (fruits[i - 1] != fruits[i]) {
                if (r >= 0 &&  fruits[i] != fruits[r]) {
                    fruitCount = Math.max(fruitCount, i - l);
                    l = r + 1;
                }
             r = i - 1;
            }
        }
        return Math.max(fruitCount, n - l);
    }
    
//     public int totalFruit(int[] fruits) {
//         int n = fruits.length;
//         int result = 0;
//         int i = 0;
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for (int j = 0; j < n; j++) {
//             map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
//             while (map.size() > 2) {
//                 map.put(fruits[i], map.get(fruits[i]) - 1);
//                 if (map.get(fruits[i]) == 0)
//                     map.remove(fruits[i]);
//                 i++;
//             }
//             result = Math.max(result, j - i + 1);
//         }
//         return result;
//     }
}