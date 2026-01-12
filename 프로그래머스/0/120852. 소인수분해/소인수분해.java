import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            // System.out.println("i : " + i);
            if (n % i == 0) {
                list.add(i);
                while (n % i == 0) {
                    n /= i; // 중복 체크 안 하니까 그냥 값만 다 쪼개주기
                }
            }
        }
        
        // 마지막 남은 거 더해주기 
        if (n > 1) {
            list.add(n);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
