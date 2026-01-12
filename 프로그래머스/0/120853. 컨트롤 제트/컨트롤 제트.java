import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String n : s.split(" ")) {
            
            if (n.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(n));
            }
        }
        
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        
        return answer;
    }
}
