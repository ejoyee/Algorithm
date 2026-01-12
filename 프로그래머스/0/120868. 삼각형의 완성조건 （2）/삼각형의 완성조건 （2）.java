class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int maxN = Math.max(sides[0], sides[1]);
        int minN = Math.min(sides[0], sides[1]);
        
        // 두 값 중 더 큰 값이 가장 긴 변일 경우
        // 더 큰 값을 넘지 않으면서, 더한 값이 더 큰 값을 넘어야 함
        answer += maxN - (maxN - minN);
        
        // 나머지 한 변이 가장 긴 변일 경우
        answer += (minN + maxN -1) - (maxN);
        
        return answer;
    }
}