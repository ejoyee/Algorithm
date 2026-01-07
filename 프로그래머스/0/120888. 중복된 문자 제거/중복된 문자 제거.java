import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        Deque<Character> q = new ArrayDeque<>();
        
        for (int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            
            System.out.println(c);
            
            if (!q.contains(c)){
                q.addLast(c);
            }
        }

        while (!q.isEmpty()) {
            sb.append(q.pollFirst());
        }
        
        return sb.toString();
    }
}