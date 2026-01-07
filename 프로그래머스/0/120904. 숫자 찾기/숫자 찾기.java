import java.util.*;

class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        
        String nToS = Integer.toString(num);
        String kToS = Integer.toString(k);
        
        if (nToS.contains(kToS)) {
            answer = nToS.indexOf(kToS)+1;
        }
        else {
            answer = -1;
        }
        
        return answer;
    }
}