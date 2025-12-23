import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){
            if (st.empty()){
                if (s.charAt(i) == '('){
                    st.push(s.charAt(i));
                }
                else {
                    answer = false;
                    break;
                }
            }
            else {
                if (s.charAt(i) == '('){
                    st.push(s.charAt(i));
                }
                else {
                    if (st.peek() == ')'){
                        answer = false;
                        break;
                    }
                    else {
                        st.pop();
                    }
                }
            }
        }
        
        if (!st.empty()) answer = false;

        return answer;
    }
}