class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) 
            return 0;
        // Sort the arrays with increasing order of starts
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        
        int count = 1;
        int end = intervals[0][1];
        
        // Count the number of overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            // Overlapping
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
            // Disjoint
            else {
                end = Math.min(end, intervals[i][1]);
            }
        }
        // Total intervals - Number of overlapping intervals
        return intervals.length - count;
    }
}
