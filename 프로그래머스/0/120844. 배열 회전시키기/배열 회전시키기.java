import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int number : numbers) {
            dq.addLast(number);
        }
        
        if (direction.equals("right")){
            dq.addFirst(dq.pollLast());
        }
        else {
            dq.addLast(dq.pollFirst());
        }
        
        return dq.stream().mapToInt(i -> i).toArray();
    }
}