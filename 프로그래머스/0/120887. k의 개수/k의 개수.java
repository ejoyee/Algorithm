class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        char target = (char) (k + '0'); 

        for (int f = i; f <= j; f++) {
            String s = String.valueOf(f);

            for (int idx = 0; idx < s.length(); idx++) {
                if (s.charAt(idx) == target) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
