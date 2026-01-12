class Solution {
    public int solution(String my_string) {
        
        String[] tmp  = my_string.split(" ");
        
        int answer = Integer.parseInt(tmp[0]);
        
        for (int i = 1; i < tmp.length; i += 2) {
            String pOrM = tmp[i];
            int num = Integer.parseInt(tmp[i + 1]);

            if (pOrM.equals("+")) answer += num;
            else answer -= num;
        }

        return answer;
    }
}
