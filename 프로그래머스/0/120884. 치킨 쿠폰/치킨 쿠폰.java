class Solution {
    public int solution(int chicken) {
        int answer = -1;
        
        while (chicken >= 10) {
            chicken -= 9;
            answer ++;
            
            // System.out.println(chicken);
        }
        
        return answer+1;
    }
}