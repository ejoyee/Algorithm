class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        
        int[] nums = new int[1001];
        
        for (int i = 0; i < array.length; i++) {
            nums[array[i]]++;
        }
        
        answer = nums[n];
        return answer;
    }
}