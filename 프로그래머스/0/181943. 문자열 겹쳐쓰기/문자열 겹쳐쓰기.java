class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";

        for (int i = 0; i < s; i++) {
            answer += my_string.charAt(i);
        }

        answer += overwrite_string;
        answer += my_string.substring(s + overwrite_string.length());

        return answer;
    }
}
