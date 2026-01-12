class Solution {
    public int[] solution(int[][] score) {
        
        int size = score.length;
        int[] answer = new int[size];
        
        int[] sum = new int[size];
        for (int i = 0; i < size; i++){
            sum[i] = score[i][0] + score[i][1];
        }
        
        for (int i = 0; i < size; i++){
            int rank = 1;
            
            for (int j = 0; j < size; j++){
                if (sum[i] < sum[j]) rank++;
            }
            
            answer[i] = rank;
        }
        
        return answer;
    }
}