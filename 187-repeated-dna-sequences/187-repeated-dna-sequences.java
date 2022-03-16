class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> table = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String c = s.substring(i, i + 10);
            if (table.contains(c)) {
                result.add(c);
            }
            table.add(c);
        }
        return new ArrayList<String>(result);
    }
}