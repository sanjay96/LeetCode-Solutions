class Solution {
    
    public String removeDuplicates(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        
        int i = 0;
        int j = -1;
        
        while (i < n) {
            if (j == -1 || c[i] != c[j]) {
                c[++j] = c[i];
                i++;
            }
            else {
                i++;
                j--;
            }
        }
        return new String(c, 0, j + 1);
    }
    
    // Using a stack
    // public String removeDuplicates(String s) {
    //     Stack<Character> stack = new Stack<>();
    //     for (char c : s.toCharArray()) {
    //         if (stack.isEmpty()) {
    //             stack.push(c);
    //         }
    //         else {
    //             if (stack.peek() == c) 
    //                 stack.pop();
    //             else
    //                 stack.push(c);
    //         }
    //     }
    //     if (stack.isEmpty())
    //         return new String();
    //     else {
    //         StringBuilder sb = new StringBuilder();
    //         while(!stack.isEmpty()) {
    //             sb.append(stack.pop());
    //         }
    //         return sb.reverse().toString();
    //     }
    // }
}