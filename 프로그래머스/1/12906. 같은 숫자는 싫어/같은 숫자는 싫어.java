import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> list = new Stack<>();
        
        list.push(arr[0]);
        for (int i = 1; i < arr.length; i++){
            if (!list.peek().equals(arr[i])){
                list.push(arr[i]);
            }
        }
        
        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}