import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = {};
        
        // 그냥 int 배열 sort... 실패함 o1 o2  했더니 (검색함))
        Integer[] tmp = Arrays.stream(numlist).boxed().toArray(Integer[]::new); 
        
        Arrays.sort(tmp, (o1, o2) -> {
            int a = Math.abs(o1 - n);
            int b = Math.abs(o2 - n);

            if (a != b) return a - b;
            return o2 - o1; // 더 큰 애
        });
        
        return Arrays.stream(tmp).mapToInt(i->i).toArray();
    }
}