class Solution {
    public int solution(int[] common) {
        
        int plus = common[1] - common[0];
        
        if (common[2] - common[1] == plus) {
            return common[common.length-1] + plus;
        }
        
        int mult = common[1] / common[0];
        return common[common.length-1] * mult;
        
    }
}