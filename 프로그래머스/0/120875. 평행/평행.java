class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        // 기울기 구하는 공식 (검색함)
        // (y2-y1) / (x2-x1)
        // 근데 곱하기로 바꾸겠음
        
        // 0 1 / 2 3
        if (ph(dots[0], dots[1], dots[2], dots[3])) return 1;
        // 0 2 / 1 3
        if (ph(dots[0], dots[2], dots[1], dots[3])) return 1;
        // 0 3 / 1 2
        if (ph(dots[0], dots[3], dots[1], dots[2])) return 1;
        
        return answer;
    }
    
    static boolean ph (int[] first1, int[] first2, int[] second1, int[] second2) {
        
        int firstX = first2[0] - first1[0];
        int firstY = first2[1] - first1[1];
        
        int secondX = second2[0] - second1[0];
        int secondY = second2[1] - second1[1];
        
        // 원래면 firstY / firstX == secondY / secondX
        // firstY * secondX == secondY * firstX
        
        if (firstY * secondX == secondY * firstX) return true;
        else return false;
    }
}