import java.util.*;
class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        char[] str1 = before.toCharArray();
        char[] str2 = after.toCharArray();
        
        Arrays.sort(str1);
        Arrays.sort(str2);
        
        answer = 1;
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] != str2[i]) {
                answer = 0;
                break;
            }
        }
        
        return answer;
    }
}