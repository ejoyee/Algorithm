class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        
        int total = box[0] * box[1] * box[2];
        
        // box 0 : 가로
        // box 1 : 세로
        // box 2 : 높이
        
        int r = box[0] / n;
        int c = box[1] / n;
        int h = box[2] / n;
        
        answer = r * c * h;
        
        return answer;
    }
}