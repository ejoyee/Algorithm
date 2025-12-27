import java.util.*;

class Solution {
    public String solution(int age) {
        String answer = "";
        char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        
        String str = Integer.toString(age);
        
        for (int i = 0; i < str.length(); i++) {
            int tmp = str.charAt(i) - '0';
            answer += alphabets[tmp];
        }     
        return answer;
    }
}