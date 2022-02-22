class Solution {
    public int titleToNumber(String columnTitle) {
        int count = 0;
        int factor = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            count = count + (columnTitle.charAt(i) - 'A' + 1) * factor;
            factor = factor * 26;
        }
        return count;
    }
}