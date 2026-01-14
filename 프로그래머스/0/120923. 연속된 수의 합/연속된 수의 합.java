class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        // 시작 값을 찾으면 갯수만큼?
        // n, n+1, n+2 ... num 3일 때
        // 3n+ 3 = 12
        // n + 1 = 4
        // n = 3
        
        // a부터 b까지의 연속된 숫자의 합 공식 (검색함) (a + b) * (b - a) / 2
        // 엥 1부터면 됨 n(n+1) /  2
        // num * x + num * (num+1)/2 = total
        // num * x = total - num * (num+1)/2
        // x = (total - num*(num+1)/2) / num;
        
        int start = (total - num*(num - 1)/2) / num;
        // 근데 0부터여서 num+1이 아니라 -1
        
        
        for (int i = 0; i < num; i++) {
            answer[i] = start++;
        }
        
        return answer;
    }
}