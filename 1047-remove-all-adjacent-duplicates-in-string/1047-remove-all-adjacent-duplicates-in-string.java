class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            }
            else {
                if (stack.peek() == c) 
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        if (stack.isEmpty())
            return new String();
        else {
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }
}