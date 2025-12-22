import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int maxCnt = 0;
        
        for (int i = 0; i < array.length; i++){
            hm.put(array[i], hm.getOrDefault(array[i], 0) + 1);
            
            if (hm.get(array[i]) > maxCnt){
                maxCnt = hm.get(array[i]);
                answer = array[i];
            }
            else if ( hm.get(array[i]) == maxCnt) {
                answer = -1;
            }
        }
        
        
        return answer;
    }
}