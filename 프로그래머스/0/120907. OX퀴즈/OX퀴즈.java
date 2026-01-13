class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int t = 0; t < quiz.length; t++) {
            
            String[] list = quiz[t].split(" ");
            
            int x = Integer.parseInt(list[0]);
            int y = Integer.parseInt(list[2]);
            int qans = Integer.parseInt(list[4]);

            int ans = 0; 
            if (list[1].equals("+")) ans = x + y;
            else ans = x - y;
            
            if (qans == ans) answer[t] = "O";
            else answer[t] = "X";
        }
        
        return answer;
    }
}