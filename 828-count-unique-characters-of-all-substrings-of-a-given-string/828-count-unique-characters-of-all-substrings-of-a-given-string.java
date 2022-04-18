class Solution {
    public int uniqueLetterString(String s) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(index[i], -1);
        }
        
        int result = 0;
        int N = s.length();
        int mod = (int) Math.pow(10, 9) + 7;
        
        for (int i = 0; i < N; i++) {
            int c = s.charAt(i) - 'A';
            result = (result + ((i - index[c][1]) * (index[c][1] - index[c][0])) % mod) % mod;
            index[c] = new int[]{index[c][1], i};
        }
        
        for (int i = 0; i < 26; i++) {
            result = (result + ((N - index[i][1]) * (index[i][1] - index[i][0])) % mod) % mod;
        }
        
        return result;
    }
}