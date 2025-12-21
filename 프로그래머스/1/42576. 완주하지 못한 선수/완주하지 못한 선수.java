import java.util.*;


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();

        // 참가자 카운트
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 완주자 차감
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        // 완주 못한 선수 찾기
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
            }
        }
        
        return answer;
    }
}