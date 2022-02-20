class Solution {
    public int removeCoveredIntervals(int[][] intervals) { 
        Arrays.sort(intervals, (x, y) -> (x[0] - y[0]));
        int count = 0, left = -1, right = -1;
        for (int[] interval: intervals) {
            if (interval[0] > left && interval[1] > right) {
                left = interval[0];
                count = count + 1;
            }
            right = Math.max(right, interval[1]);
        }
        return count;
    }
}