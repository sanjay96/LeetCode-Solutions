class Solution { 
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length, max = m + n;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) 
                    continue;
                int top = max, left = max;
                if (row - 1 >= 0) 
                    top = mat[row - 1][col];
                if (col - 1 >= 0) 
                    left = mat[row][col - 1];
                mat[row][col] = Math.min(top, left) + 1;
            }
        }
        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (mat[row][col] == 0) continue;
                int bottom = max, right = max;
                if (row + 1 < m) 
                    bottom = mat[row + 1][col];
                if (col + 1 < n) 
                    right = mat[row][col + 1];
                mat[row][col] = Math.min(mat[row][col], Math.min(bottom, right) + 1);
            }
        }
        return mat;
    }
}