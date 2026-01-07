class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        
        int mI = 0;
        int mV = 0;
        
        for (int i = 0; i < array.length; i++){
            if (array[i] > mV ){
                mI = i;
                mV = array[i];
            }
        }
        
        answer[0] = mV;
        answer[1] = mI;
        
        return answer;
    }
}