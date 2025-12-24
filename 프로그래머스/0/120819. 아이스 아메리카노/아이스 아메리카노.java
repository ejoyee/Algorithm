import java.util.*;

class Solution {
    public int[] solution(int money) {
        List<Integer> list = new ArrayList<>();
        
        list.add(money / 5500);
        list.add(money % 5500);

        return list.stream().mapToInt(i -> i).toArray();
    }
}