import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        for (int i = 0; i < my_string.length(); i++) {
            char tmp = my_string.charAt(i);
            
            if (tmp >= '0' && tmp <= '9') answer += tmp - '0';
        }
        
        return answer;
    }
}