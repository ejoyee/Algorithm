class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for (int i = 0; i < my_string.length(); i++){
            char tmp = my_string.charAt(i);
            
            if (tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u') {
                continue;
            }
            else {
                answer += tmp;
            }
        }
        
        return answer;
    }
}