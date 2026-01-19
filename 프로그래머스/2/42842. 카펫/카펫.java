class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        // total = w * h;
        // yellow = (w-2) * (h-2);
        // brown = w*h - (w-2)*(h-2);
        // 2w - 2h + 4
        
        for (int h = 1; h <= total; h++){
            
            int w = total / h;
            
            if ((w-2) <= 0 && (h-2) <= 0) continue;
            if ((w - 2) * (h - 2) == yellow) {
                answer[0] = Math.max(w, h);
                answer[1] = Math.min(w, h);
                
            }
            
        }
        
        return answer;
    }
}