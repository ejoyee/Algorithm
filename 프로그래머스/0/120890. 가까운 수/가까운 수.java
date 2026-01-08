class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        int m = Math.abs(array[0] - n);

        for (int i = 1; i < array.length; i++) {
            int tmp  = Math.abs(array[i] - n);

            if (tmp < m) {
                m = tmp;
                answer = array[i];
            } else if (tmp == m && array[i] < answer) {
                answer = array[i];
            }
        }

        return answer;
    }
}
