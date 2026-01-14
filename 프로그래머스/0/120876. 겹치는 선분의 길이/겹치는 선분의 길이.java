class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int[] cnt = new int[201]; 
        int zero = 100;

        for (int[] line : lines) {
            int a = line[0];
            int b = line[1];
            for (int x = a; x < b; x++) { 
                cnt[x + zero]++;
            }
        }
        
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] >= 2) answer++;
        }
        return answer;
    }
}
