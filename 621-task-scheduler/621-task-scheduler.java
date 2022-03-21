class Solution {
    // Greedy
    public int leastInterval(char[] tasks, int n) {
        int[] table = new int[26];
        int max = 0;
        int maxCount = 0;
        
        for (char task : tasks) {
            table[task - 'A']++;
            if (max == table[task - 'A'])
                maxCount++;
            else if (max < table[task - 'A']) {
                max = table[task - 'A'];
                maxCount = 1;
            }
        }
        
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
}