import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0; 
        int maxH = 0; 
        
        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            int big = Math.max(w, h);
            int small = Math.min(w, h);
            
            maxW = Math.max(maxW, big);
            maxH = Math.max(maxH, small);
        }
        
        return maxW * maxH;
    }
}
