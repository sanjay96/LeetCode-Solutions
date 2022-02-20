class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals.length == 1) 
            return intervals;
        
        //Sort the intervals based on the start value
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        
        var result = new ArrayList<int[]>();
        var newInterval = intervals[0];
        result.add(newInterval);
        
        for (int[] interval : intervals) {
            
            // Check if intervals are overlapping 
            // if yes, move the end if needed
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            // Not overlapping
            // Add to the list
            else {
                newInterval = interval;
		result.add(newInterval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
