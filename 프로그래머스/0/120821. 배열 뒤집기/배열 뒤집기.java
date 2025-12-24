import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int num : num_list) {
            dq.addFirst(num);
        }
        
        return dq.stream().mapToInt(i -> i).toArray();
    }
}