import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= n; i++){
            if (i % 2 == 1) {
                list.add(i);
            }
        }
        
        // 이 부분 헷갈려서 검색해봄
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}