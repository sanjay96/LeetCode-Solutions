class Solution {
    
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }
    
    // public List<String> findRepeatedDnaSequences(String s) {
    //     Set<String> result = new HashSet<>();
    //     Set<String> table = new HashSet<>();
    //     int i = 0, j = 10;
    //     for (int i = 0; i < s.length() - 9; i++) {
    //         String c = s.substring(i, i + 10);
    //         if (table.contains(c)) {
    //             result.add(c);
    //         }
    //         table.add(c);
    //     }
    //     return new ArrayList<String>(result);
    // }
}