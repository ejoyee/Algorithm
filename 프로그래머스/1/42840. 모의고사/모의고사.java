import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        // 1 2 3 4 5
        // 2 1 2 3 2 4 2 5
        // 3 3 1 1 2 2 4 4 5 5
        
        int[] ans1 = {1, 2, 3,  4, 5};
        int[] ans2 = {2, 1 ,2, 3, 2 , 4, 2, 5};
        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int stu1 = 0;
        int stu2 = 0;
        int stu3 = 0;
        
        for (int i = 0; i < answers.length; i++){
            if (answers[i] == ans1[i%5]) stu1++;
            if (answers[i] == ans2[i%8]) stu2++;
            if (answers[i] == ans3[i%10]) stu3++;
        }
        
        int maxScore = Math.max(stu1, Math.max(stu2, stu3));
        List<Integer> list = new ArrayList<>();

        if (stu1 == maxScore) list.add(1);
        if (stu2 == maxScore) list.add(2);
        if (stu3 == maxScore) list.add(3);
        
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}