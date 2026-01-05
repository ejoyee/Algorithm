import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);

        int n = numbers.length;

        // 가장 작은 수 두 개의 곱 (- * - = +) 또는 가장 큰 수 두 개의 곱
        int max1 = numbers[n - 1] * numbers[n - 2]; 
        int max2 = numbers[0] * numbers[1];

        answer = Math.max(max1, max2);
        
        return answer;
    }
}