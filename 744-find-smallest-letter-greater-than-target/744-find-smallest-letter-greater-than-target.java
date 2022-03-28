class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        if (target >= letters[letters.length - 1])
            target = letters[0];
        else 
            target++;
        
        int left = 0, right = letters.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] == target)
                return letters[mid];
            else if (letters[mid] > target)
                right = mid;
            else 
                left = mid + 1;
        }
        return letters[right];
    }
}