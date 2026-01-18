import java.util.*;

class Solution {
    
    static char[] nums;
    static boolean[] isSelected;
    static Set<Integer> set;
    
    public int solution(String numbers) {
        int answer = 0;
        
        nums = numbers.toCharArray();
        isSelected = new boolean[nums.length];
        
        set = new HashSet<>();
        
        dfs(0);
        
        answer = set.size();
        return answer;
    }
    
    
    static void dfs (int cur) {
        if (cur > 0) {
            if (isPrime(cur)) {
                set.add(cur);
            }
        }
        
        for (int i = 0; i < nums.length; i++){
            if (isSelected[i]) continue;
            
            isSelected[i] = true;
            dfs(cur*10 + (nums[i] - '0'));
            isSelected[i] = false;
        }
        
    } 
    
    // 소수 판별 (검색함)
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}