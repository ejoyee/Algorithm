import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < my_string.length(); i++){
            char tmp = my_string.charAt(i);
            
            if (tmp >= '0' && tmp <= '9') {
                list.add(tmp - '0');
            }
        }
        
        Collections.sort(list);
        
        answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}